package net.okjsp.commboard.service;

import java.util.List;

import net.okjsp.commboard.model.Board;

/**
 * User: yawn
 * Date: 2014. 01. 14.
 * Time: 오전 2:46
 * Description : 공통 게시판을 위한 Service
 */
public interface BoardService {
	public List<Board> getCommunityBoardList();
}
