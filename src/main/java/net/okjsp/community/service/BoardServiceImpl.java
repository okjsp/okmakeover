package net.okjsp.community.service;

import net.okjsp.community.dao.BoardDao;
import net.okjsp.community.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: langerhans
 * Date: 2014. 2. 13.
 * Time: 오후 1:32
 * Description : BoardServiceImpl
 */
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardDao boardDao;

    @Override
    public List<Board> getBoardList() {
        return null;
    }

    @Override
    public List<Board> getBoardListById(int boardId) {
        List<Board> boards = boardDao.getBoardListById(boardId);
        return boards;
    }
}
