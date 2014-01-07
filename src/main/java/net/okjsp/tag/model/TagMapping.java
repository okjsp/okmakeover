package net.okjsp.tag.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 태그 매핑 Model.
 *
 * @author jaeger
 */
public class TagMapping implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 게시판 ID
     */
    private Integer boardId;

    /**
     * 글 번호
     */
    private Integer writeId;

    /**
     * 태그명
     */
    private String tagName;



    /**
     * 게시판 ID Getter.
     *
     * @return 게시판 ID
     */
    public Integer getBoardId() {
        return boardId;
    }

    /**
     * 게시판 ID Setter.
     *
     * @param boardId 게시판 ID
     */
    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    /**
     * 글 번호 Getter.
     *
     * @return 글 번호
     */
    public Integer getWriteId() {
        return writeId;
    }

    /**
     * 글 번호 Setter.
     *
     * @param writeId 글 번호
     */
    public void setWriteId(Integer writeId) {
        this.writeId = writeId;
    }

    /**
     * 태그명 Getter.
     *
     * @return 태그명
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * 태그명 Setter.
     *
     * @param tagName 태그명
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
