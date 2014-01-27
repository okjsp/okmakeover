package net.okjsp.tag.dao;

import net.okjsp.tag.model.Tag;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 태그 Dao.
 *
 * @author jaeger
 */
@Repository
public interface TagDao {

    /**
     * 태그 목록 조회.
     *
     * @param tagName 태그명
     * @return 태그 목록
     */
    public List<Tag> selectList(@Param("tagName") String tagName);

    /**
     * 태그 총 개수.
     *
     * @param tagName 태그명
     * @return 태그 총 개수
     */
    public Integer selectTotalCount(@Param("tagName") String tagName);

    /**
     * 태그 조회.
     *
     * @param tagName 태그명
     * @return 태그
     */
    public Tag selectOne(@Param("tagName") String tagName);

    /**
     * 태그 등록.
     *
     * @param tag 태그
     * @return 태그 등록 개수
     */
    public Integer insert(Tag tag);

    /**
     * 태그 수정.
     *
     * @param tag 태그
     * @return 태그 수정 개수
     */
    public Integer update(Tag tag);

    /**
     * 태그 삭제.
     *
     * @param tagName 태그명
     * @return 태그 삭제 개수
     */
    public Integer delete(@Param("tagName") String tagName);
    
    /**
     * 태그 리스트(매핑과 조인하여 게시글에 해당하는 Tag만 조회)
     * @param boardId
     * @param writeNo
     * @return
     */
	public List<Tag> selectMappingList(@Param("boardId") Integer boardId, @Param("writeNo") Integer writeNo);

}

