package net.okjsp.commboard.service;

import java.util.List;

import net.okjsp.commboard.dao.CommboardDao;
import net.okjsp.commboard.model.Board;
import net.okjsp.commboard.model.Commboard;
import net.okjsp.common.model.Paging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommboardServiceImple implements CommboardService {
	@Autowired
	CommboardDao boardDao;

	@Override
	public List<Board> getCommunityBoardList() {
		List<Board> communityBoardList = boardDao.selectCommunityBoardList();
		
		return communityBoardList;
	}
	
	@Override
	public List<Commboard> getCommBoardList(int boardId, int categoryId,
			Paging paging) {
		
		List<Commboard> list = boardDao.selectCommonBoardList(boardId, categoryId, paging.getOffset(), paging.getSizePerList());
		
	    return list;
	}

	@Override
	public int getTotalCount(int boardId, int categoryId) {
		int count = boardDao.selectTotalCount(boardId, categoryId);

        return count;
	}
	
	@Override
	public Commboard getCommboard(int writeNo) {
		return boardDao.selectCommBoard(writeNo);
	}

	@Override
	public boolean addPostingHit(int writeNo) {
		int count = boardDao.addPostingHit(writeNo);

		if (count > 0 ) {
			return true;
		}
        return false;
	}

	@Override
	public boolean create(Commboard commboard) {
		boolean result = false;

        int count = boardDao.insertCommBoard(commboard);

        if(count > 0) {
            result = true;
        }

        return result;
	}

	@Override
	public boolean modify(Commboard commboard) {
		boolean result = false;

        int count = boardDao.updateCommBoard(commboard);

        if(count > 0) {
            result = true;
        }

        return result;
	}

	@Override
	public boolean delete(int writeNo) {
		boolean result = false;

        int count = boardDao.deleteCommboard(writeNo);

        if(count > 0) {
            result = true;
        }

        return result;
	}

}
