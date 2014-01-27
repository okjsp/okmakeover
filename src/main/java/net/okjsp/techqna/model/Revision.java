package net.okjsp.techqna.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * Revision Model.
 *
 * @author jaeger
 */
public class Revision implements Serializable {
    private static final long serialVersionUID = 1L;



    /**
     * Q/A 게시물 번호
     */
    private Integer writeNo;
    /**
     * Q/A 수정한 게시물 번호
     */
    private Integer revisionSeq;
    /**
     * 리비전 제목
     */
    private String revisionTitle;
    /**
     * 리비전 내용
     */
    private String Content;
    /**
     * 리비전 태그명
     */
    private String tagName;
    /**
     * 수정 내역
     */
    private String Summary;
    /**
     * 작성일자
     */
    private Date writeDate;



    /**
     * Q/A 게시물 번호 Getter.
     *
     * @return Q/A 게시물 번호
     */
    public Integer getWriteNo() {
        return writeNo;
    }

    /**
     * Q/A 게시물 번호 Setter.
     *
     * @param writeNo Q/A 게시물 번호
     */
    public void setWriteNo(Integer writeNo) {
        this.writeNo = writeNo;
    }

    /**
     * Q/A 수정한 게시물 번호 Getter.
     *
     * @return Q/A 수정한 게시물 번호
     */
    public Integer getRevisionSeq() {
        return revisionSeq;
    }

    /**
     * Q/A 수정한 게시물 번호 Setter.
     *
     * @param revisionSeq Q/A 수정한 게시물 번호
     */
    public void setRevisionSeq(Integer revisionSeq) {
        this.revisionSeq = revisionSeq;
    }

    /**
     * 리비전 제목 Getter.
     *
     * @return 리비전 제목
     */
    public String getRevisionTitle() {
        return revisionTitle;
    }

    /**
     * 리비전 제목 Setter.
     *
     * @param revisionTitle 리비전 제목
     */
    public void setRevisionTitle(String revisionTitle) {
        this.revisionTitle = revisionTitle;
    }

    /**
     * 리비전 내용 Getter.
     *
     * @return 리비전 내용
     */
    public String getContent() {
        return Content;
    }

    /**
     * 리비전 내용 Setter.
     *
     * @param content 리비전 내용
     */
    public void setContent(String content) {
        Content = content;
    }

    /**
     * 리비전 태그명 Getter.
     *
     * @return 리비전 태그명
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * 리비전 태그명 Setter.
     *
     * @param tagName 리비전 태그명
     */
    public void setTagName(String tagName) {
        this.tagName = tagName.substring(1, tagName.length() - 1).replaceAll(" ", "");
    }

    /**
     * 수정 내역 Getter.
     *
     * @return 수정 내역
     */
    public String getSummary() {
        return Summary;
    }

    /**
     * 수정 내역 Setter.
     *
     * @param summary 수정 내역
     */
    public void setSummary(String summary) {
        Summary = summary;
    }

    /**
     * 작성일자 Getter.
     *
     * @return 작성일자
     */
    public Date getWriteDate() {
        return writeDate;
    }

    /**
     * 작성일자 Setter.
     *
     * @param writeDate 작성일자
     */
    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
