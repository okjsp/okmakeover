package net.okjsp.community.service;

import net.okjsp.community.model.Board;

import java.util.List;

/**
 * User: langerhans
 * Date: 2014. 2. 13.
 * Time: 오후 1:23
 * Description : BoardService
 */
public interface BoardService {
    public List<Board> getBoardList();
    public List<Board> getBoardListById(int boardId);
}
