package net.okjsp.community.service;

import java.util.List;

import net.okjsp.community.model.Article;
import net.okjsp.community.model.Board;
import net.okjsp.common.model.Paging;

/**
 * User: yawn
 * Date: 2014. 01. 14.
 * Time: 오전 2:46
 * Description : 공통 게시판을 위한 Service
 */
public interface CommunityService {
	public List<Board> getCommunityBoardList();

	public List<Article> getArticles(int boardId, int categoryId,
                                     Paging paging);
	
	public Article getArticle(int writeNo);

	public int getTotalCount(int boardId, int categoryId);

	public boolean addArticleHit(int writeNo);
	
	public boolean create(Article article);

    public boolean modify(Article article);

    public boolean delete(int writeNo);
}
