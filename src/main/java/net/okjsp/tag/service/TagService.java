package net.okjsp.tag.service;

import net.okjsp.tag.model.Tag;
import net.okjsp.tag.model.TagMapping;

import java.util.List;


/**
 * 태그 Service 인터페이스.
 *
 * @author jaeger
 */
public interface TagService {

    /**
     * 태그 등록.
     *
     * @param boardId 게시물 아이디
     * @param writeId 글쓴이 아이디
     * @param tagList 태그 리스트
     * @return 태그 등록 성공 여부
     */
    public boolean createTag(Integer boardId, Integer writeId, String[] tagList);

    /**
     * 게시물에 해당하는 태그 목록(매핑) 조회.
     *
     * @param boardId 게시물 아이디
     * @param writeId 글쓴이 아이디
     * @return 태그 리스트 목록
     */
    public List<TagMapping> selectTagMappingList(Integer boardId, Integer writeId);
    
    /**
     * 게시물에 해당하는 태그 목록 조회.
     *
     * @param boardId 게시물 아이디
     * @param writeId 글쓴이 아이디
     * @return 태그 리스트 목록
     */
    public List<Tag> selectTagList(Integer boardId, Integer writeId);

    /**
     * 태그 입력시 태그 자동완성 목록 조회.
     *
     * @param tag 태그
     * @return 태그 목록
     */
    public List<Tag> selectTagAutoComplete(String tag);

    /**
     * 게시물 태그에 해당하는 태그 통계
     * 해당하는 게시물에 태그 목록 조회해서, 태그 통계 조회함.
     *
     * @param boardId 게시물 아이디
     * @return 태그 통계 목록
     */
    public List<Tag> selectTagStatistics(Integer boardId);

}

