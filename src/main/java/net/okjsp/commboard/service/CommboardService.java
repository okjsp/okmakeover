package net.okjsp.commboard.service;

import java.util.List;

import net.okjsp.commboard.model.Board;
import net.okjsp.commboard.model.Commboard;
import net.okjsp.common.model.Paging;

/**
 * User: yawn
 * Date: 2014. 01. 14.
 * Time: 오전 2:46
 * Description : 공통 게시판을 위한 Service
 */
public interface CommboardService {
	public List<Board> getCommunityBoardList();

	public List<Commboard> getCommBoardList(int boardId, int categoryId,
			Paging paging);
	
	public Commboard getCommboard(int writeNo);

	public int getTotalCount(int boardId, int categoryId);

	public boolean addPostingHit(int writeNo);
	
	public boolean create(Commboard commboard);

    public boolean modify(Commboard commboard);

    public boolean delete(int writeNo);
}
