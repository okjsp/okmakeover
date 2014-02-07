package net.okjsp.commboard.dao;

import net.okjsp.commboard.model.Comment;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentDao {

    public List<Comment> selectList(
            @Param("boardNo") String boardNo,
            @Param("writeNo") String writeNo,
            @Param("searchFlg") String searchflg,
            @Param("search") String search,
            @Param("sort") String sort,
            @Param("offset") int offset,
            @Param("sizePerList") int sizePerList );

    public int selectTotalCount(
            @Param("boardNo") String boardNo,
            @Param("writeNo") String writeNo );

    public Comment selectOne( 
    		@Param("boardNo") String boardNo,
            @Param("writeNo") String writeNo,
            @Param("commentId") String commentId );
    

    public int insert(Comment comment);

    public int update(Comment comment);

    public int delete(
    		@Param("boardNo") String boardNo,
            @Param("writeNo") String writeNo,
            @Param("commentId") String commentId);
 
}
