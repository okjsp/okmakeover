package net.okjsp.post.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Post {
	
	/**
	 * 쪽지 마스터 ID
	 */
	private long postId;
	
	/**
	 * 쪽지 시퀀스
	 */
	private int postSeq;
	
	/**
	 * 사용자 ID
	 */
	private String userId;
	
	/**
	 * 쪽지 구분 ( 보낸 쪽지/받은 쪽지)
	 */
	private String postType;
	
	/**
	 * 타겟 ID (보낸 사람/받는 사람)
	 */
	private String targetId;
	
	/**
	 * 쪽지 상태 (읽음 :Y, 안읽음 : N)
	 */
	private String postStatus;
	
	/**
	 * 보낸 날짜
	 */
	@DateTimeFormat(style="MM")
	private Date sendDate;
	
	/**
	 * 읽은 날짜
	 */
	@DateTimeFormat(style="MM")
	private Date checkDate;
	
	/**
	 * 쪽지 내용
	 */
	private String content;
	
	/**
	 * @return the postId
	 */
	public long getPostId() {
		return postId;
	}

	/**
	 * @param postId the postId to set
	 */
	public void setPostId(long postId) {
		this.postId = postId;
	}

	/**
	 * @return the postSeq
	 */
	public int getPostSeq() {
		return postSeq;
	}

	/**
	 * @param postSeq the postSeq to set
	 */
	public void setPostSeq(int postSeq) {
		this.postSeq = postSeq;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the postType
	 */
	public String getPostType() {
		return postType;
	}

	/**
	 * @param postType the postType to set
	 */
	public void setPostType(String postType) {
		this.postType = postType;
	}

	/**
	 * @return the targetId
	 */
	public String getTargetId() {
		return targetId;
	}

	/**
	 * @param targetId the targetId to set
	 */
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	/**
	 * @return the postStatus
	 */
	public String getPostStatus() {
		return postStatus;
	}

	/**
	 * @param postStatus the postStatus to set
	 */
	public void setPostStatus(String postStatus) {
		this.postStatus = postStatus;
	}

	
	/**
	 * @return the sendDate
	 */
	public Date getSendDate() {
		return sendDate;
	}

	/**
	 * @param sendDate the sendDate to set
	 */
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	/**
	 * @return the checkDate
	 */
	public Date getCheckDate() {
		return checkDate;
	}

	/**
	 * @param checkDate the checkDate to set
	 */
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
}
