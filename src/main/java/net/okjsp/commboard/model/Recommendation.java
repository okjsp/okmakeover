package net.okjsp.commboard.model;

public class RecommendationVO {
	//게시판 번호
	private int borad_id;
	//글 번호
	private int write_no;
	//덧글 번호
	private int comment_id;
	//구분 아이디???
	private String guboon_id;
	//뭐지...
	private String intpropose_id;
	//추천 점수
	private String score;
	//추천 날짜
	private String recommendation_date;
	public int getBorad_id() {
		return borad_id;
	}
	public void setBorad_id(int borad_id) {
		this.borad_id = borad_id;
	}
	public int getWrite_no() {
		return write_no;
	}
	public void setWrite_no(int write_no) {
		this.write_no = write_no;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public String getGuboon_id() {
		return guboon_id;
	}
	public void setGuboon_id(String guboon_id) {
		this.guboon_id = guboon_id;
	}
	public String getIntpropose_id() {
		return intpropose_id;
	}
	public void setIntpropose_id(String intpropose_id) {
		this.intpropose_id = intpropose_id;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getRecommendation_date() {
		return recommendation_date;
	}
	public void setRecommendation_date(String recommendation_date) {
		this.recommendation_date = recommendation_date;
	}
	
	

}
