package net.okjsp.community.model;

import java.io.Serializable;

public class Board implements Serializable {

    private static final long serialVersionUID = -3404588398820203356L;

    // 게시판ID
	private int boardId;
	
	// 게시판명
	private String boardName;
	
	// 하위 카테고리 ID
	private int categoryId;
	
	// 하위 카테고리 명
	private String categoryName;
	
	// 답변기능 사용여부
	private Boolean replayCheck;
	
	// 추천기능 사용여부
	private Boolean recommendCheck;
	
	// 싸움방지기능 사용여부
	private Boolean brawlCheck;
	
	// 댓글기능 사용여부
	private Boolean commentCheck;
	
	// 작성일시
	private String writeDate;
	
	// 업데이트일시
	private String updateDate;

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	

	public Boolean getReplayCheck() {
		return replayCheck;
	}

	public void setReplayCheck(Boolean replayCheck) {
		this.replayCheck = replayCheck;
	}

	public Boolean getRecommendCheck() {
		return recommendCheck;
	}

	public void setRecommendCheck(Boolean recommendCheck) {
		this.recommendCheck = recommendCheck;
	}

	public Boolean getBrawlCheck() {
		return brawlCheck;
	}

	public void setBrawlCheck(Boolean brawlCheck) {
		this.brawlCheck = brawlCheck;
	}

	public Boolean getCommentCheck() {
		return commentCheck;
	}

	public void setCommentCheck(Boolean commentCheck) {
		this.commentCheck = commentCheck;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
}