package net.okjsp.recommendation.service;

import java.util.List;

import net.okjsp.recommendation.dao.BoardRecommendDao;
import net.okjsp.recommendation.model.BoardRecommend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BoardRecommendService 구현체
 * 
 * @author yjc0703
 *
 */
@Service
public class BoardRecommendServiceImpl implements BoardRecommendService {

    @Autowired
    BoardRecommendDao boardRecommendDao;


    /**
     * 게시물 구분(추천/반대/신고) : 게시물 등록.
     *
     * @param userId 회원 아이디
     * @param boardId 게시판 아이디
     * @param writeNo 게시물 아이디
     * @param type 구분값 (추천/반대/신고)
     */
    @Override
    public void addRecommendation(int userId, int boardId, int writeNo, BoardRecommend.Type type) {
        // 게시물인 경우에는 댓글 아이디가 "0"으로 들어간다.
        this.addRecommendation(userId, boardId, writeNo, 0, type);
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
    public void addRecommendation(int userId, int boardId, int writeNo, int commentId, BoardRecommend.Type type) {
        BoardRecommend boardRecommend = new BoardRecommend();
        boardRecommend.setBoardId(boardId);
        boardRecommend.setWriteNo(writeNo);
        boardRecommend.setCommentId(commentId);
        boardRecommend.setUserId(userId);
        boardRecommend.setTypeId(type);
        
        this.addRecommendation(boardRecommend);
    }

    /**
     * 추천/반대/신고 프로세스.
     *
     * @param boardRecommend 추천/반대/신고
     */
    @Override
    public void addRecommendation(BoardRecommend boardRecommend) {
        // 중복 체크
        if (boardRecommendDao.selectOne(boardRecommend).size() > 0) {
            throw new RuntimeException("이미 " + boardRecommend.getGuboonName() + "되었습니다.");
        }

        boardRecommendDao.insert(boardRecommend);
    }

    /**
     * 게시물 추천/반대/신고 리스트.
     *
     * @param boardId 게시판 아이디
     * @param writeNo 글쓴이 아이디
     * @return 추천/반대/신고 : 게시물 리스트
     */
    @Override
    public List<BoardRecommend> getRecommendation(int boardId, int writeNo) {
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
    public List<BoardRecommend> getRecommendation(int boardId, int writeNo, int commentId) {
        List<BoardRecommend> list = boardRecommendDao.selectRecommendations(boardId, writeNo, commentId);
        
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
    public List<BoardRecommend> getRecommendationByGuboon(int boardId, int writeNo, String type) {
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
    public List<BoardRecommend> getRecommendationByGuboon(int boardId, int writeNo, int commentId, String type) {
        List<BoardRecommend> list = boardRecommendDao.selectRecommendationsByGuboon(boardId, writeNo, commentId, type);
        
        return list;
    }
}
