package net.okjsp.commboard.model;

public class BoardVO {

	// 게시판ID
	private int boardId;
	
	// 게시판명
	private String boardName;
	
	// 하위 카테고리 ID
	private int categoryId;
	
	// 하위 카테고리 명
	private String categoryName;
	
	// 답변기능 사용여부
	private String replayCheck;
	
	// 추천기능 사용여부
	private String recommendCheck;
	
	// 싸움방지기능 사용여부
	private String brawlCheck;
	
	// 댓글기능 사용여부
	private String commentCheck;
	
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

	public String getReplayCheck() {
		return replayCheck;
	}

	public void setReplayCheck(String replayCheck) {
		this.replayCheck = replayCheck;
	}

	public String getRecommendCheck() {
		return recommendCheck;
	}

	public void setRecommendCheck(String recommendCheck) {
		this.recommendCheck = recommendCheck;
	}

	public String getBrawlCheck() {
		return brawlCheck;
	}

	public void setBrawlCheck(String brawlCheck) {
		this.brawlCheck = brawlCheck;
	}

	public String getCommentCheck() {
		return commentCheck;
	}

	public void setCommentCheck(String commentCheck) {
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