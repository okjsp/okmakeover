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


    /**
     * Tech QNA 리스트(질문목록)
     * 
     * @param paging 페이징
     * @param sortType 정렬기준(최근순, 답변많은순 등등...)
     * @return Tach QNA 리스트
     */
    @Override
    public List<TechQna> selectTechQnaList(Paging paging, String sortType) {
        return this.selectTechQnaList(paging, sortType, null);
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
        /*
            관계가 있는 내부 property 들을 모두 단일 쿼리로 수행시키기 때문에 (qna 1 건당 3회)
            (paging.getSizePerList() * 3) + 1 의 DB IO가 발생함.
            mybatis association 으로 분리하는 방법 학습 후 반드시 리펙토링할 것.
        */
        List<TechQna> techQnaList = null;

        if (tagName == null) {
            techQnaList = techQnaDao.selectTechQnaList(sortType, paging.getOffset(), paging.getSizePerList());
        } else {
            techQnaList = techQnaDao.selectTechQnaListByTag(tagName, sortType, paging.getOffset(), paging.getSizePerList());
        }
        
        for(TechQna techQna : techQnaList) {
            // Tech Q/a 게시판 Board ID : 4
            techQna.setRecommendationList(recommendationService.getRecommendation(4, techQna.getWriteNo()));
            techQna.setTagList(tagService.selectTagList(4, techQna.getWriteNo()));
            techQna.setUser(userService.getOne(techQna.getUserId()));
        }

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
    public List<TechQna> selectTechQnaDetail(Integer WriteNo) {
        /*
            관계가 있는 내부 property 들을 모두 단일 쿼리로 수행시키기 때문에 (qna 1 건당 3회)
            (paging.getSizePerList() * 3) + 1 의 DB IO가 발생함.
            mybatis association 으로 분리하는 방법 학습 후 반드시 리펙토링할 것.
        */
        List<TechQna> techQnaList = techQnaDao.selectTechQnaDetail(WriteNo);
        
        for(TechQna techQna : techQnaList) {
            // Tech Q/a 게시판 Board ID : 4
            techQna.setRecommendationList(recommendationService.getRecommendation(4, techQna.getWriteNo()));
            techQna.setTagList(tagService.selectTagList(4, techQna.getWriteNo()));
            techQna.setUser(userService.getOne(techQna.getUserId()));
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
        Revision revision = new Revision();
        revision.setWriteNo(techQna.getWriteNo());
        revision.setRevisionTitle(techQna.getQnaTitle());
        revision.setContent(techQna.getContent());
        revision.setTagName(techQna.getTagList().toString());
        revision.setSummary("신규 등록");

        revisionDao.insert(revision);
        techQnaDao.insert(techQna);
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
