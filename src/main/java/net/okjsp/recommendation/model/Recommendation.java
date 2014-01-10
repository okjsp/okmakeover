package net.okjsp.recommendation.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * 추천 Model.
 *
 * @author jaeger
 */
public class Recommendation implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 추천
     */
    public static final String RECOMMEND = "1";
    /**
     * 반대
     */
    public static final String OPPOSE = "2";
    /**
     * 신고
     */
    public static final String ACCUSE = "3";
    
    /**
     * 게시판 ID
     */
    private Integer boardId;
    /**
     * 게시글 번호
     */
    private Integer writeNo;
    /**
     * 댓글 ID
     */
    private Integer commentId;
    /**
     * 추천 구분 (추천/반대/신고)
     */
    private String guboonId;
    /**
     * 추천인 ID
     */
    private String userId;
    /**
     * 추천 점수
     */
    private String score;
    /**
     * 추천 날짜
     */
    private Date recommendationDate;


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
     * 게시글 번호 Getter.
     *
     * @return 게시글 번호
     */
    public Integer getWriteNo() {
        return writeNo;
    }

    /**
     * 게시글 번호 Setter.
     *
     * @param writeNo 게시글 번호
     */
    public void setWriteNo(Integer writeNo) {
        this.writeNo = writeNo;
    }

    /**
     * 댓글 ID Getter.
     *
     * @return 댓글 ID
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * 댓글 ID Setter.
     *
     * @param commentId 댓글 ID
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * 추천 구분 Getter.
     *
     * @return 추천 구분
     */
    public String getGuboonId() {
        return guboonId;
    }

    /**
     * 추천 구분 Setter.
     *
     * @param guboonId 추천 구분
     */
    public void setGuboonId(String guboonId) {
        this.guboonId = guboonId;
    }

    /**
     * 추천인 ID Getter.
     *
     * @return 추천인 ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 추천인 ID Setter.
     *
     * @param proposeId 추천인 ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 추천 점수 Getter.
     *
     * @return 추천 점수
     */
    @Deprecated
    public String getScore() {
        return score;
    }

    /**
     * 추천 점수 Setter.
     *
     * @param score 추천 점수
     */
    @Deprecated
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * 추천 날짜 Getter.
     *
     * @return 추천 날짜
     */
    public Date getRecommendationDate() {
        return recommendationDate;
    }

    /**
     * 추천 날짜 Setter.
     *
     * @param recommendationDate 추천 날짜
     */
    public void setRecommendationDate(Date recommendationDate) {
        this.recommendationDate = recommendationDate;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
