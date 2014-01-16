package net.okjsp.recommendation.service;

import java.util.List;

import net.okjsp.recommendation.dao.RecommendationDao;
import net.okjsp.recommendation.model.Recommendation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RecommendationService 구현체
 * 
 * @author yjc0703
 *
 */
@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    RecommendationDao recommendationDao;


    /**
     * 게시물 구분(추천/반대/신고) : 게시물 등록.
     *
     * @param userId 회원 아이디
     * @param boardId 게시판 아이디
     * @param writeNo 게시물 아이디
     * @param type 구분값 (추천/반대/신고)
     */
    @Override
    public void setRecommendation(int userId, int boardId, int writeNo, String type) {
        // 게시물인 경우에는 댓글 아이디가 "0"으로 들어간다.
        this.setRecommendation(userId, boardId, writeNo, 0, type);
    }

    /**
     * 게시물 구분(추천/반대/신고) : 댓글 등록.
     *
     * @param userId 회원 아이디
     * @param boardId 게시판 아이디
     * @param writeNo 게시물 아이디
     * @param commentId 댓글 아이디
     * @param type 구분값 (추천/반대/신고)
     */
    @Override
    public void setRecommendation(int userId, int boardId, int writeNo, int commentId, String type) {
        Recommendation recommendation = new Recommendation();
        recommendation.setBoardId(boardId);
        recommendation.setWriteNo(writeNo);
        recommendation.setCommentId(commentId);
        recommendation.setUserId(userId);
        recommendation.setGuboonId(type);
        
        this.setRecommendation(recommendation);
    }

    /**
     * 추천/반대/신고 프로세스.
     *
     * @param recommendation 추천/반대/신고
     */
    @Override
    public void setRecommendation(Recommendation recommendation) {

        // 중복 체크
        if (recommendationDao.selectOne(recommendation).size() > 0) {
            throw new RuntimeException("이미 " + recommendation.getGuboonName() + "되었습니다.");
        }

        recommendationDao.insert(recommendation);
    }

    /**
     * 게시물 추천/반대/신고 리스트.
     *
     * @param boardId 게시판 아이디
     * @param writeNo 글쓴이 아이디
     * @return 추천/반대/신고 : 게시물 리스트
     */
    @Override
    public List<Recommendation> getRecommendation(int boardId, int writeNo) {
        return getRecommendation(boardId, writeNo, 0);
    }

    /**
     * 댓글 추천/반대/신고 리스트.
     *
     * @param boardId 게시판 아이디
     * @param writeNo 글쓴이 아이디
     * @param commentId 댓글 아이디
     * @return 추천/반대/신고 : 댓글 리스트
     */
    @Override
    public List<Recommendation> getRecommendation(int boardId, int writeNo, int commentId) {
        List<Recommendation> list = recommendationDao.selectRecommendations(boardId, writeNo, commentId);
        
        return list;
    }

    /**
     * 추천/반대/신고에 해당하는 구분 값별 게시물 목록
     *
     * @param boardId 게시판 아이디
     * @param writeNo 글쓴이 아이디
     * @param type 구분 값
     * @return 구분 값 리스트
     */
    @Override
    public List<Recommendation> getRecommendationByGuboon(int boardId, int writeNo, String type) {
        return getRecommendationByGuboon(boardId, writeNo, 0, type);
    }

    /**
     * 추천/반대/신고에 해당하는 구분 값별 댓글 목록
     *
     * @param boardId 게시판 아이디
     * @param writeNo 글쓴이 아이디
     * @param commentId 댓글 아이디
     * @param type 구분 값
     * @return 구분 값 리스트
     */
    @Override
    public List<Recommendation> getRecommendationByGuboon(int boardId, int writeNo, int commentId, String type) {
        List<Recommendation> list = recommendationDao.selectRecommendationsByGuboon(boardId, writeNo, commentId, type);
        
        return list;
    }

}
