package net.okjsp.commboard.model;

public class Recommendation {
	//게시판 번호
	private int boradId;
	//글 번호
	private int writeNo;
	//덧글 번호
	private int commentId;
	//구분 아이디???
	private String guboonId;
	//뭐지...
	private String intproposeId;
	//추천 점수
	private String score;
	//추천 날짜
	private String recommendationDate;
	
	public int getBoradId() {
		return boradId;
	}
	public void setBoradId(int boradId) {
		this.boradId = boradId;
	}
	public int getWriteNo() {
		return writeNo;
	}
	public void setWriteNo(int writeNo) {
		this.writeNo = writeNo;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getGuboonId() {
		return guboonId;
	}
	public void setGuboonId(String guboonId) {
		this.guboonId = guboonId;
	}
	public String getIntproposeId() {
		return intproposeId;
	}
	public void setIntproposeId(String intproposeId) {
		this.intproposeId = intproposeId;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getRecommendationDate() {
		return recommendationDate;
	}
	public void setRecommendationDate(String recommendationDate) {
		this.recommendationDate = recommendationDate;
	}
	
	
	
	
	
	

}
