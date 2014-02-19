package net.okjsp.techqna.service;

import java.util.List;

import net.okjsp.common.model.Paging;
import net.okjsp.recommendation.service.RecommendationService;
import net.okjsp.tag.service.TagService;
import net.okjsp.techqna.dao.RevisionDao;
import net.okjsp.techqna.dao.TechQnaDao;
import net.okjsp.techqna.model.Revision;
import net.okjsp.techqna.model.TechQna;
import net.okjsp.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * TechQna Service 구현체.
 * 
 * @author yjc0703
 */
@Service
public class TechQnaServiceImpl implements TechQnaService {

    @Autowired
    private TechQnaDao techQnaDao;

    @Autowired
    private RevisionDao revisionDao;

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private TagService tagService;

    @Autowired
    private UserService userService;
    
    private final Integer BOARD_ID = 4;
    
    /**
	 * question total count
	 * 	
	 * @return question total count
	 */
	public Integer selectTechQnaTotalCount() {
		return this.selectTechQnaByTagTotalCount("");
	}
	
	/**
	 * question total count(by tag)
	 * 
	 * @param tagName
	 * @return question total count
	 */
	public Integer selectTechQnaByTagTotalCount(String tagName) {
		if ("".equals(tagName)) {
			return techQnaDao.selectTechQnaTotalCount();
		} else {
			return techQnaDao.selectTechQnaByTagTotalCount(tagName);
		}
	}

    /**
     * Tech QNA 리스트(질문목록)
     * 
     * @param paging 페이징
     * @param sortType 정렬기준(최근순, 답변많은순 등등...)
     * @return Tach QNA 리스트
     */
    @Override
    public List<TechQna> selectTechQnaList(Paging paging, String sortType) {
        return this.selectTechQnaList(paging, sortType, "");
    }

    /**
     * Tech QNA 리스트(질문목록)
     * 
     * @param paging 페이징
     * @param sortType 정렬기준(최근순, 답변많은순 등등...)
     * @return Tech Q/A 리스트
     */
    @Override
    public List<TechQna> selectTechQnaList(Paging paging, String sortType, String tagName) {

        List<TechQna> techQnaList = null;

        if ("".equals(tagName)) {
            techQnaList = techQnaDao.selectTechQnaList(sortType, paging.getOffset(), paging.getSizePerList());
        } else {
            techQnaList = techQnaDao.selectTechQnaListByTag(tagName, sortType, paging.getOffset(), paging.getSizePerList());
        }

         techQnaList = setTechQnaProperties(techQnaList);

        return techQnaList;
    }

    /**
     * Tech QNA Detail
     * 질문 클릭 후 내용보기 화면에서 사용
     *     
     * @param WriteNo 게시글번호(Question 기준)
     * @return Tech QNA 리스트(1 Question + N Answers.. LinkedList로 순서 섞이지 않게)
     */
    @Override
    public List<TechQna> selectTechQnaDetail(Integer writeNo) {

        List<TechQna> techQnaList = techQnaDao.selectTechQnaDetail(writeNo);
        
         techQnaList = setTechQnaProperties(techQnaList);
        
        return techQnaList;
    }
    
    private List<TechQna> setTechQnaProperties(List<TechQna> techQnaList) {
    	
    	for(TechQna techQna : techQnaList) {
            // Tech Q/a 게시판 Board ID : 4
            techQna.setRecommendationList(recommendationService.getRecommendation(BOARD_ID, techQna.getWriteNo()));
            techQna.setTagList(tagService.selectTagList(BOARD_ID, techQna.getWriteNo()));
            
            //techQna.setUser(userService.getOne(techQna.getUserId()));
        }
    	
    	return techQnaList;
    }

    /**
     * Tech QNA 생성
     * 
     * @param techQna
     */
    @Override
    public void createTechQna(TechQna techQna) {
    	
    	techQnaDao.insert(techQna);
    	
        Revision revision = new Revision();
        revision.setWriteNo(techQna.getWriteNo());
        revision.setRevisionTitle(techQna.getQnaTitle());
        revision.setContent(techQna.getContent());
        revision.setSummary("신규 등록");
        revision.setRevisionSeq(revisionDao.selectMaxRevisionSeq(techQna.getWriteNo()));
        revision.setTagName(techQna.getTagList().toString());
        
        revisionDao.insert(revision);
        tagService.createTag(BOARD_ID, techQna.getWriteNo(), techQna.getTagList());
    }
    
    /**
     * Tech QNA 수정
     * 
     * @param techQna
     */
    @Override
    public void updateTechQna(TechQna techQna) {
        Revision revision = new Revision();
        revision.setWriteNo(techQna.getWriteNo());
        revision.setRevisionTitle(techQna.getQnaTitle());
        revision.setContent(techQna.getContent());
        revision.setTagName(techQna.getTagList().toString());
        revision.setSummary("신규 등록");    // parameter는 어디서 받지? qna? revision? 아니면 별도 String?
        
        revisionDao.insert(revision);
        techQnaDao.update(techQna);
    }

    /**
     * Tech QNA Revision List
     * 변경이력 조회 화면에서 사용
     * 
     * @param writeNo 글 번호
     */
    @Override
    public List<Revision> selectRevisionList(Integer writeNo) {
        List<Revision> revisionList = revisionDao.selectRevisionList(writeNo);
        return revisionList;
    }

}
