package net.okjsp.commboard.service;

import java.util.List;

import net.okjsp.commboard.dao.BoardDao;
import net.okjsp.commboard.model.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImple implements BoardService {
	@Autowired
	BoardDao boardDao;

	@Override
	public List<Board> getCommunityBoardList() {
		List<Board> communityBoardList = boardDao.selectCommunityBoardList();
		
		return communityBoardList;
	}

}
