package net.okjsp.tag.service;


import net.okjsp.tag.model.Tag;

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
     * @param tag 태그 정보
     * @return 태그 등록 성공 여부
     */
    public boolean createTag(Integer boardId, Integer writeId, Tag tag);

}
