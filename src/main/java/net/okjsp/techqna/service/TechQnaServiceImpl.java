package net.okjsp.techqna.service;

import java.util.List;

import net.okjsp.common.model.Paging;
import net.okjsp.community.service.CommentService;
import net.okjsp.recommendation.model.BoardRecommendOperator;
import net.okjsp.recommendation.service.BoardRecommendService;
import net.okjsp.tag.service.TagService;
import net.okjsp.techqna.dao.RevisionDao;
import net.okjsp.techqna.dao.TechQnaDao;
import net.okjsp.techqna.model.Revision;
import net.okjsp.techqna.model.TechQna;
import net.okjsp.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    private BoardRecommendService boardRecommendService;

    @Autowired
    private TagService tagService;

    @Autowired
    private UserService userService;
 
    // private final Integer BOARD_ID = 4;
    
    /**
	 * question total count
	 * 	
	 * @return question total count
	 */
	public Integer selectTechQnaTotalCount(int boardId, int categoryId) {
		return this.selectTechQnaByTagTotalCount(boardId, categoryId, "");
	}
	
	/**
	 * question total count(by tag)
	 * 
	 * @param tagName
	 * @return question total count
	 */
	public Integer selectTechQnaByTagTotalCount(int boardId, int categoryId, String tagName) {
		if ("".equals(tagName)) {
			return techQnaDao.selectTechQnaTotalCount(boardId, categoryId);
		} else {
			return techQnaDao.selectTechQnaByTagTotalCount(boardId, categoryId, tagName);
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
    public List<TechQna> selectTechQnaList(int boardId, int categoryId, Paging paging, String sortType) {
        return this.selectTechQnaList(boardId, categoryId, paging, sortType, "");
    }

    /**
     * Tech QNA 리스트(질문목록)
     * 
     * @param paging 페이징
     * @param sortType 정렬기준(최근순, 답변많은순 등등...)
     * @return Tech Q/A 리스트
     */
    @Override
    public List<TechQna> selectTechQnaList(int boardId, int categoryId, Paging paging, String sortType, String tagName) {

        List<TechQna> techQnaList = null;

        if ("".equals(tagName)) {
            techQnaList = techQnaDao.selectTechQnaList(boardId, categoryId, sortType, paging.getOffset(), paging.getSizePerList());
        } else {
            techQnaList = techQnaDao.selectTechQnaListByTag(boardId, categoryId, tagName, sortType, paging.getOffset(), paging.getSizePerList());
        }

        setPropertiesToTechQnaList(techQnaList);

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
    public List<TechQna> selectTechQnaDetail(int boardId, int categoryId, Integer writeNo) {

        List<TechQna> techQnaList = techQnaDao.selectTechQnaDetail(boardId, categoryId, writeNo);
        
        setPropertiesToTechQnaList(techQnaList);
        
        return techQnaList;
    }
    
    /**
     * Tech QNA Detail
     * 질문 클릭 후 내용보기 화면에서 사용
     *     
     * @param WriteNo 게시글번호(Question 기준)
     * @return Tech QNA
     */
    @Override
    public TechQna selectOneTechQnaQuestion(int boardId, int categoryId, Integer writeNo) {

    	TechQna techQna = techQnaDao.selectOneTechQnaQuestion(boardId, categoryId, writeNo);
        
        setPropertiesToTechQna(techQna);
        
        return techQna;
    }
    
    /**
     * Tech QNA Detail
     * 질문 클릭 후 내용보기 화면에서 사용
     *     
     * @param WriteNo 게시글번호(Question 기준)
     * @return Tech QNA 리스트
     */
    @Override
    public List<TechQna> selectTechQnaAnswers(int boardId, int categoryId, Integer writeNo) {

        List<TechQna> techQnaList = techQnaDao.selectTechQnaAnswers(boardId, categoryId, writeNo);
        
        setPropertiesToTechQnaList(techQnaList);
        
        return techQnaList;
    }

    /**
     * Tech QNA Detail
     * 질문 수정에 사용
     *     
     * @param WriteNo 게시글번호(Question 기준)
     * @return Tech QNA 리스트
     */
    @Override
    public TechQna selectOneTechQnaAnswer(int boardId, int categoryId, Integer writeNo, Integer parentId) {

    	TechQna techQna = techQnaDao.selectOneTechQnaAnswer(boardId, categoryId, writeNo, parentId);
        
    	setPropertiesToTechQna(techQna);
        
        return techQna;
    }

    private void setPropertiesToTechQnaList(List<TechQna> techQnaList) {
    	for(TechQna techQna : techQnaList) {
    		setPropertiesToTechQna(techQna);
        }
    }
    
    private void setPropertiesToTechQna(TechQna techQna) {
    	if (techQna != null) {
    		// Tech Q/a 게시판 Board ID : 4
			techQna.setBoardRecommendOperator(getRecommentOperator(techQna));
		    techQna.setTagList(tagService.selectTagList(techQna.getBoardId(), techQna.getWriteNo()));
    	}
    }
    
    private BoardRecommendOperator getRecommentOperator(TechQna techQna) {
		BoardRecommendOperator boardRecommendOperator = new BoardRecommendOperator();
		boardRecommendOperator.setBoardRecommendList(boardRecommendService.getRecommendation(techQna.getBoardId(), techQna.getWriteNo()));    
		
		return boardRecommendOperator;
    }

    /**
     * Tech QNA 생성
     * 
     * @param techQna
     */
    @Override
    @Transactional
    public void createTechQna(TechQna techQna) {
    	techQnaDao.insert(techQna);    
    	
    	insertRevisionAndTag(techQna, "신규 등록");
    }
    
    /**
     * Tech QNA 수정
     * 
     * @param techQna
     */
    @Override
    @Transactional
    public void updateTechQna(TechQna techQna) {
        insertRevisionAndTag(techQna, "변경 등록");
        
    	techQnaDao.update(techQna);        
    }
    
    // TODO : Summary 데이터 받을 위치 선전(TechQna에 Summary 추가 [방안1])
    private Revision createRevision(TechQna techQna, String summary) {
        Revision revision = new Revision();
        revision.setRevisionSeq(revisionDao.selectMaxRevisionSeq(techQna.getWriteNo()));
        revision.setWriteNo(techQna.getWriteNo());
        revision.setRevisionTitle(techQna.getQnaTitle());
        revision.setContent(techQna.getContent());
        revision.setTagName(techQna.getTagList().toString());
        revision.setSummary(summary);
        
        return revision;
    }
    
    // TODO : 함수 의미 전달이 좀 이상한듯 보임. 적당한 함수명을 생각하여 변경해야 함.
    private void insertRevisionAndTag(TechQna techQna, String summary) {
        revisionDao.insert(createRevision(techQna, summary));
        tagService.createTag(techQna.getBoardId(), techQna.getWriteNo(), techQna.getTagList());
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
    
    /**
	 * Tech QNA 조회수 증가
	 * 
	 * @param WriteNo 글 번호
	 */
	public void incTechQnaHit(int WriteNo) {
		techQnaDao.incPostingHit(WriteNo);
	}

}
