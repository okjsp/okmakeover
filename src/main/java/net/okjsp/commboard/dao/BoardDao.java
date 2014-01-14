package net.okjsp.commboard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.okjsp.commboard.model.Board;

@Repository
public interface BoardDao {
	public List<Board> selectCommunityBoardList();
}
