package net.okjsp.tag.service;

import net.okjsp.tag.model.Tag;
import java.util.List;


/**
 * 태그 Service 인터페이스.
 *
 * @author jaeger
 */
public interface TagService {

    /**
     * 태그 단건 등록.
     *
     * @param boardId 게시물 아이디
     * @param writeId 글쓴이 아이디
     * @param tag 태그 정보
     * @return 태그 등록 성공 여부
     */
    public boolean createTag(Integer boardId, Integer writeId, Tag tag);

    /**
     * 태그 다건 등록.
     *
     * @param boardId 게시물 아이디
     * @param writeId 글쓴이 아이디
     * @param tagList 태그 목록 정보
     * @return 태그 등록 성공 여부
     */
    public boolean createTag(Integer boardId, Integer writeId, List<String> tagList);

    /**
     * 태그 수정.
     * (태그 매핑 테이블에 게시물/글쓴이에 해당하는 태그 전부 삭제하고, 전부 등록)
     *
     * @param boardId 게시물 아이디
     * @param writeId 글쓴이 아이디
     * @param tagList 태그 목록 정보
     * @return 태그 수정 성공 여부
     */
    public boolean modifyTag(Integer boardId, Integer writeId, List<String> tagList);

    /**
     * 태그 삭제.
     * (태그 매핑 테이블에 게시물/글쓴이에 해당하는 태그 삭제)
     *
     * @param boardId 게시물 아이디
     * @param writeId 글쓴이 아이디
     * @return 태그 삭제 성공 여부
     */
    public boolean removeTag(Integer boardId, Integer writeId);

    /**
     * 게시물에 해당하는 태그 목록 조회.
     *
     * @param boardId 게시물 아이디
     * @param writeId 글쓴이 아이디
     * @return 태그 목록
     */
    public List<Tag> selectTagMappingList(Integer boardId, Integer writeId);

    /**
     * 태그 입력시 태그 자동완성 목록 조회.
     * (태그 테이블)
     *
     * @param tag 태그
     * @return 태그 목록
     */
    public List<Tag> selectTagAutoComplete(Tag tag);

    /**
     * 게시물 태그에 해당하는 태그 통계.
     * (해당하는 게시물에 태그 목록 조회해서, 태그 통계 조회함)
     *
     * @param boardId 게시물 아이디
     * @param writeId 글쓴이 아이디
     * @return 태그 통계 목록
     */
    public List<Tag> selectTagStatistics(Integer boardId, Integer writeId);

}
