package net.okjsp.recommendation.dao;

import net.okjsp.recommendation.model.Recommendation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 추천/반대/신고 Dao.
 *
 * @author yjc0703
 */
@Repository
public interface RecommendationDao {

    List<Recommendation> selectOne(Recommendation r);

    /**
     * 게시글에 대한 추천/반대/신고 리스트
     *
     * @param boardId
     * @param writeNo
     * @param commentId
     * @return
     */
    public List<Recommendation> selectRecommendations(@Param("boardId") int boardId,
                                                      @Param("writeNo") int writeNo,
                                                      @Param("commentId") int commentId);

    /**
     * 게시글에 대한 추천/반대/신고 리스트(구분별)
     *
     * @param boardId
     * @param writeNo
     * @param commentId
     * @param guboonId
     * @return
     */
    public List<Recommendation> selectRecommendationsByGuboon(@Param("boardId") int boardId,
                                                              @Param("writeNo") int writeNo,
                                                              @Param("commentId") int commentId,
                                                              @Param("guboonId") String guboonId);

    /**
     * 유저별 전체 추천/반대/신고 리스트
     * 추후 개인화 작업에서 활용(내가 추천한 글, 내가 반대한 글, 내가 신고한 글)
     *
     * @param userId
     * @return
     */
    public List<Recommendation> selectRecommendationsByUser(@Param("userId") int userId);

    /**
     * 게시물에 대한 구분 별 count
     *
     * @param boardId
     * @param writeNo
     * @param commentId
     * @param guboonId
     * @return
     */
    public Integer selectCountByGuboon(@Param("boardId") int boardId,
                                       @Param("writeNo") int writeNo,
                                       @Param("commentId") int commentId,
                                       @Param("guboonId") String guboonId);

    /**
     * 추천, 반대, 신고 등록
     *
     * @param r
     * @return
     */
    public Integer insert(Recommendation r);

    /**
     * 추천, 반대, 신고 삭제
     *
     * @param boardId
     * @param writeNo
     * @param commentId
     * @param guboonId
     * @param userId
     * @return
     */
    public Integer delete(@Param("boardId") int boardId,
                          @Param("writeNo") int writeNo,
                          @Param("commentId") int commentId,
                          @Param("guboonId") String guboonId,
                          @Param("userId") int userId);
}
