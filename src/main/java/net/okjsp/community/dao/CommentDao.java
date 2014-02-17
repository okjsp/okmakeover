package net.okjsp.community.dao;

import net.okjsp.community.model.Comment;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentDao {

    public List<Comment> selectListForArticle(
            @Param("boardNo") int boardNo,
            @Param("writeNo") int writeNo);

    public List<Comment> selectList(
            @Param("boardNo") int boardNo,
            @Param("writeNo") int writeNo,
            @Param("searchFlg") String searchflg,
            @Param("search") String search,
            @Param("sort") String sort,
            @Param("offset") int offset,
            @Param("sizePerList") int sizePerList );

    public int selectTotalCount(
            @Param("boardNo") int boardNo,
            @Param("writeNo") int writeNo );

    public Comment selectOne( 
    		@Param("boardNo") int boardNo,
            @Param("writeNo") int writeNo,
            @Param("commentId") int commentId );
    

    public int insert(Comment comment);

    public int update(Comment comment);

    public int delete(
    		@Param("boardNo") int boardNo,
            @Param("writeNo") int writeNo,
            @Param("commentId") int commentId);
 
}
