package net.okjsp.techqna.dao;

import java.util.List;

import net.okjsp.techqna.model.Revision;

/**
 * Revision Dao
 * 
 * @author yjc0703
 *
 */
public interface RevisionDao {
	
	/**
	 * Tech QNA 에 대한 Revision 목록
	 * 
	 * @param writeNo 게시물 ID
	 * @return Revision 목록
	 */
	List<Revision> selectRevisionList(Integer writeNo);

	/**
	 * Revision 등록
	 * 
	 * @param revision 
	 */
	void insert(Revision revision);

}
