package net.okjsp.recommendation.model;

import java.io.Serializable;
import java.util.Date;

import net.okjsp.user.model.User;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 추천 Model.
 *
 * @author jaeger
 */
public class BoardRecommend implements Serializable {
    private static final long serialVersionUID = 1L;

    public static enum Type {
        RECOMMEND("추천"),
        OPPOSE("반대"),
        ACCUSE("신고");

        private String text;

        Type(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }
    }
    
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
    private Type typeId;
    /**
     * 추천인 ID
     */
    private Integer userId;
    /**
     * 추천 점수
     */
    private String score;
    /**
     * 추천 날짜
     */
    private Date recommendDate;
    
    /**
     * 추천인
     */
    private User user;


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
    public Type getTypeId() {
        return typeId;
    }

    /**
     * 추천 구분 Setter.
     *
     * @param typeId 추천 구분
     */
    public void setTypeId(Type typeId) {
        this.typeId = typeId;
    }

    /**
     * 추천인 ID Getter.
     *
     * @return 추천인 ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 추천인 ID Setter.
     *
     * @param userId 추천인 ID
     */
    public void setUserId(Integer userId) {
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
    public Date getRecommendDate() {
        return recommendDate;
    }

    /**
     * 추천 날짜 Setter.
     *
     * @param recommendDate 추천 날짜
     */
    public void setRecommendDate(Date recommendDate) {
        this.recommendDate = recommendDate;
    }
    
    /**
     * 추천인(User) getter
     *    
     * @return
     */
    public User getUser() {
		return user;
	}

    /**
     * 추천인(User) setter
     * 
     * @param user
     */
	public void setUser(User user) {
		this.user = user;
	}
    
    /**
     * typeId 에 따른 guboon 명(추천/반대/신고)
     * @return
     */
    public String getGuboonName() {
    	return this.typeId.getText();
    }

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
