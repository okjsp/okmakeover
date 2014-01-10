package net.okjsp.techqna.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * TechQna Model.
 *
 * @author jaeger
 */
public class TechQna implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 게시물 번호
     */
    private Integer writeNo;
    /**
     * 삭제 구분(Y/N)
     */
    private String guboonId;
    /**
     * 부모 게시물 ID
     */
    private String parentId;
    /**
     * 제목
     */
    private String qnaTitle;
    /**
     * 내용
     */
    private String content;
    /**
     * 조회수
     */
    private Integer postingHit;
    /**
     * 작성날짜
     */
    private Date wirteDate;
    /**
     * 수정날짜
     */
    private Date updateDate;



    /**
     * 게시물 번호 Getter.
     *
     * @return 게시물 번호
     */
    public Integer getWriteNo() {
        return writeNo;
    }

    /**
     * 게시물 번호 Setter.
     *
     * @param writeNo 게시물 번호
     */
    public void setWriteNo(Integer writeNo) {
        this.writeNo = writeNo;
    }

    /**
     * Q/A 구분 Getter.
     *
     * @return Q/A 구분
     */
    public String getGuboonId() {
        return guboonId;
    }

    /**
     * Q/A 구분
     *
     * @param guboonId Q/A 구분
     */
    public void setGuboonId(String guboonId) {
        this.guboonId = guboonId;
    }

    /**
     * 부모 게시물 ID Getter.
     *
     * @return 부모 게시물 ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 부모 게시물 ID Setter.
     *
     * @param parentId 부모 게시물 ID
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 제목 Getter.
     *
     * @return 제목
     */
    public String getQnaTitle() {
        return qnaTitle;
    }

    /**
     * 제목 Setter.
     *
     * @param qnaTitle 제목
     */
    public void setQnaTitle(String qnaTitle) {
        this.qnaTitle = qnaTitle;
    }

    /**
     * 내용 Getter.
     *
     * @return 내용
     */
    public String getContent() {
        return content;
    }

    /**
     * 내용 Setter.
     *
     * @param content 내용
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 조회수 Getter.
     *
     * @return 조회수
     */
    public Integer getPostingHit() {
        return postingHit;
    }

    /**
     * 조회수 Setter.
     *
     * @param postingHit 조회수
     */
    public void setPostingHit(Integer postingHit) {
        this.postingHit = postingHit;
    }

    /**
     * 작성일자 Getter.
     *
     * @return 작성일자
     */
    public Date getWirteDate() {
        return wirteDate;
    }

    /**
     * 작성일자 Setter.
     *
     * @param wirteDate 작성일자
     */
    public void setWirteDate(Date wirteDate) {
        this.wirteDate = wirteDate;
    }

    /**
     * 수정일자 Getter.
     *
     * @return 수정일자
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 수정일자 Setter.
     *
     * @param updateDate 수정일자
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
