package net.okjsp.recommendation.service;

import net.okjsp.recommendation.model.BoardRecommend;

import java.util.List;

/**
 *
 *
 * @author yjc0703
 */
public interface BoardRecommendService {
	
	/**
     * 게시물 구분(추천/반대/신고) : 게시물 등록.
     *
     * @param userId 회원 아이디
     * @param boardId 게시판 아이디
     * @param writeNo 게시물 아이디
     * @param type 구분값 (추천/반대/신고)
     */
    void addRecommendation(int userId, int boardId, int writeNo, BoardRecommend.Type type);
    
    /**
     * 게시물 구분(추천/반대/신고) : 댓글 등록.
     *
     * @param userId 회원 아이디
     * @param boardId 게시판 아이디
     * @param writeNo 게시물 아이디
     * @param commentId 댓글 아이디
     * @param type 구분값 (추천/반대/신고)
     */
    void addRecommendation(int userId, int boardId, int writeNo, int commentId, BoardRecommend.Type type);
    
    /**
     * 추천/반대/신고 프로세스.
     *
     * @param boardRecommend 추천/반대/신고
     */
    void addRecommendation(BoardRecommend boardRecommend);
    
    /**
     * 게시물 추천/반대/신고 리스트.
     *
     * @param boardId 게시판 아이디
     * @param writeNo 글쓴이 아이디
     * @return 추천/반대/신고 : 게시물 리스트
     */
    List<BoardRecommend> getRecommendation(int boardId, int writeNo);

    /**
     * 댓글 추천/반대/신고 리스트.
     *
     * @param boardId 게시판 아이디
     * @param writeNo 글쓴이 아이디
     * @param commentId 댓글 아이디
     * @return 추천/반대/신고 : 댓글 리스트
     */
    List<BoardRecommend> getRecommendation(int boardId, int writeNo, int commentId);

    /**
     * 추천/반대/신고에 해당하는 구분 값별 게시물 목록
     *
     * @param boardId 게시판 아이디
     * @param writeNo 글쓴이 아이디
     * @param type 구분 값
     * @return 구분 값 리스트
     */
    List<BoardRecommend> getRecommendationByGuboon(int boardId, int writeNo, String type);

    /**
     * 추천/반대/신고에 해당하는 구분 값별 댓글 목록
     *
     * @param boardId 게시판 아이디
     * @param writeNo 글쓴이 아이디
     * @param commentId 댓글 아이디
     * @param type 구분 값
     * @return 구분 값 리스트
     */
    List<BoardRecommend> getRecommendationByGuboon(int boardId, int writeNo, int commentId, String type);

}
