package net.okjsp.tag.dao;

import net.okjsp.tag.model.Tag;
import net.okjsp.tag.model.TagMapping;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 태그 매핑 Dao.
 *
 * @author jaeger
 */
@Repository
public interface TagMappingDao {

    /**
     * 태그 매핑 목록 조회.
     *
     * @param boardId 게시판 아이디
     * @param writeNo 글쓴이 아이디
     * @return 태그 매핑 목록
     */
    public List<TagMapping> selectList(@Param("boardId") Integer boardId,
                                       @Param("writeNo") Integer writeNo);

    /**
     * 게시판에 해당하는 태그 통계.
     *
     * @param boardId 게시판 아이디
     * @return 태그 목록
     */
    public List<Tag> selectStatisticsList(@Param("boardId") Integer boardId);

    /**
     * 태그 매핑 총 개수.
     *
     * @param boardId 게시판 아이디
     * @param writeNo 글쓴이 아이디
     * @param tagName 태그 네임
     * @return 태그 매핑 총 개수
     */
    public Integer selectTotalCount(@Param("boardId") String boardId,
                                    @Param("writeNo") String writeNo,
                                    @Param("tagName") String tagName);

    /**
     * 태그 조회.
     *
     * @param boardId 게시판 아이디
     * @param writeNo 글쓴이 아이디
     * @param tagName 태그명
     * @return 태그
     */
    public Tag selectOne(@Param("boardId") String boardId,
                         @Param("writeNo") String writeNo,
                         @Param("tagName") String tagName);

    /**
     * 태그 매핑 등록.
     *
     * @param tagMapping 태그 매핑
     * @return 태그 매핑 등록 개수
     */
    public Integer insert(TagMapping tagMapping);

    /**
     * 태그 매핑 수정.
     *
     * @param tagMapping 태그 매핑
     * @return 태그 매핑 수정 개수
     */
    public Integer update(TagMapping tagMapping);

    /**
     * 태그 매핑 삭제.
     *
     * @param boardId 게시판 아이디
     * @param writeNo 글쓴이 아이디
     * @return 태그 매핑 삭제 개수
     */
    public Integer delete(@Param("boardId") Integer boardId,
                          @Param("writeNo") Integer writeNo);

}

