package net.okjsp.techqna.dao;

import java.util.List;

import net.okjsp.techqna.model.Revision;
import org.springframework.stereotype.Repository;

/**
 * Revision Dao Interface.
 * 
 * @author yjc0703
 */
@Repository
public interface RevisionDao {

    /**
     * Tech QNA 에 대한 Revision 목록.
     * 
     * @param writeNo 게시물 ID
     * @return Revision 목록
     */
    public List<Revision> selectRevisionList(Integer writeNo);

    /**
     * Revision 등록.
     * 
     * @param revision Revision
     */
    public void insert(Revision revision);

}
