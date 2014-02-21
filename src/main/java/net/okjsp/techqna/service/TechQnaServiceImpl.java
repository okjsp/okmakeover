package net.okjsp.techqna.service;

import java.util.List;

import net.okjsp.common.model.Paging;
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

        techQnaList = setTechQnaListProperties(techQnaList);

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
        
         techQnaList = setTechQnaListProperties(techQnaList);
        
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
        
        if (techQna != null) setTechQnaProperties(techQna);
        
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
        
        techQnaList = setTechQnaListProperties(techQnaList);
        
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
    public TechQna selectOneTechQnaAnswer(int boardId, int categoryId, Integer writeNo, Integer answerNo) {

    	TechQna techQna = techQnaDao.selectOneTechQnaAnswer(boardId, categoryId, writeNo, answerNo);
        
    	setTechQnaProperties(techQna);
        
        return techQna;
    }
    
    private List<TechQna> setTechQnaListProperties(List<TechQna> techQnaList) {
    	
    	for(TechQna techQna : techQnaList) {
    		setTechQnaProperties(techQna);
        }
    	
    	return techQnaList;
    }
    
    private void setTechQnaProperties(TechQna techQna) {
    	// Tech Q/a 게시판 Board ID : 4
		int boardId = techQna.getBoardId();
		BoardRecommendOperator boardRecommendOperator = new BoardRecommendOperator();
		boardRecommendOperator.setBoardRecommendList(boardRecommendService.getRecommendation(boardId, techQna.getWriteNo()));
		techQna.setBoardRecommendOperator(boardRecommendOperator);
        techQna.setTagList(tagService.selectTagList(boardId, techQna.getWriteNo()));
        // techQna.setCommentList(commentList);
        //techQna.setUser(userService.getOne(techQna.getUserId()));
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
        tagService.createTag(techQna.getBoardId(), techQna.getWriteNo(), techQna.getTagList());
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
        revision.setRevisionSeq(revisionDao.selectMaxRevisionSeq(techQna.getWriteNo()));
        revision.setSummary("변경 등록");    // parameter는 어디서 받지? qna? revision? 아니면 별도 String?
        
        revisionDao.insert(revision);
        techQnaDao.update(techQna);
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
