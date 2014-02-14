package net.okjsp.community.dao;

import java.util.List;

import net.okjsp.community.model.Article;
import net.okjsp.community.model.Board;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityDao {
	public List<Article> selectAticles(
            @Param("boardId") int boardId,
            @Param("categoryId") int categoryId,
            @Param("offset") int offset,
            @Param("sizePerList") int sizePerList);
	
	 public int selectTotalCount(
			 @Param("boardId") int boardId,
			 @Param("categoryId") int categoryId);
	 
	 public Article selectArticle(@Param("writeNo") int writeNo);

	 public int insertArticle(Article article);
	 
	 public int updateArticle(Article article);
	 
	 public int deleteArticle(@Param("writeNo") int writeNo);
	 
	 public int addArticleHit(@Param("writeNo") int writeNo);
}