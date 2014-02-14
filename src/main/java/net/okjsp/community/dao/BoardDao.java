package net.okjsp.community.dao;

import net.okjsp.community.model.Board;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: langerhans
 * Date: 2014. 2. 13.
 * Time: 오후 1:15
 * Description : BoardDao
 */
@Repository
public interface BoardDao {

    public List<Board> getBoardList();

    public List<Board> getBoardListById(@Param("boardId") int boardId);

}
