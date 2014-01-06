package net.okjsp.commboard.model;

public class Commonboard {

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
	
	// 내용
	private String content;
	
	// 조회수
	private int postingHit;
	
	// 작성일시
	private String writeDate;
	
	// 업데이트 일시
	private String updateDate;
}
