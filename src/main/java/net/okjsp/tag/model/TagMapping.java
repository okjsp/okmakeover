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
    private Integer writeNo;
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
    public Integer getWriteNo() {
        return writeNo;
    }

    /**
     * 글 번호 Setter.
     *
     * @param writeNo 글 번호
     */
    public void setWriteNo(Integer writeNo) {
        this.writeNo = writeNo;
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

