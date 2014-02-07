package net.okjsp.commboard.dao;

import java.util.List;

import net.okjsp.commboard.model.Board;
import net.okjsp.commboard.model.Commboard;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommboardDao {
	public List<Board> selectCommunityBoardList();
	public List<Commboard> selectCommonBoardList(
			@Param("boardId") int boardId,
			@Param("categoryId") int categoryId,
            @Param("offset") int offset,
            @Param("sizePerList") int sizePerList);
	
	 public int selectTotalCount(
			 @Param("boardId") int boardId,
			 @Param("categoryId") int categoryId);
	 
	 public Commboard selectCommBoard(@Param("writeNo") int writeNo);

	 public int insertCommBoard(Commboard commboard);
	 
	 public int updateCommBoard(Commboard commboard);
	 
	 public int deleteCommboard(@Param("writeNo") int writeNo);
	 
	 public int addPostingHit(@Param("writeNo") int writeNo);
}