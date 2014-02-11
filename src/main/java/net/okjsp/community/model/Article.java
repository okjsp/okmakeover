package net.okjsp.community.model;

import net.okjsp.user.model.User;

public class Article {

	// 게시판ID
	private int boardId;
	
	// 하위 카테고리명
	private int categoryId;
	
	// 삭제구분 플래그(Y/N)
	private String guboonId;
	
	// 공통 글번호
	private int writeNo;
	
	// 회원 아이디
	private String userId;
	
	// 제목
	private String commonTitle;
	
	//익명글 체크
	private String anonymousCheck;
	
	//익명글 닉네임
	private String anonymousNickname;
	
	// 내용
	private String content;
	
	// 조회수
	private int postingHit;
	
	// 작성일시
	private String writeDate;
	
	// 업데이트 일시
	private String updateDate;
	
	//작성자
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getGuboonId() {
		return guboonId;
	}

	public void setGuboonId(String guboonId) {
		this.guboonId = guboonId;
	}

	public int getWriteNo() {
		return writeNo;
	}

	public void setWriteNo(int writeNo) {
		this.writeNo = writeNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommonTitle() {
		return commonTitle;
	}

	public void setCommonTitle(String commonTitle) {
		this.commonTitle = commonTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPostingHit() {
		return postingHit;
	}

	public void setPostingHit(int postingHit) {
		this.postingHit = postingHit;
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

	public String getAnonymousCheck() {
		return anonymousCheck;
	}

	public void setAnonymousCheck(String anonymousCheck) {
		this.anonymousCheck = anonymousCheck;
	}

	public String getAnonymousNickname() {
		return anonymousNickname;
	}

	public void setAnonymousNickname(String anonymousNickname) {
		this.anonymousNickname = anonymousNickname;
	}
	
	
	
	
}
