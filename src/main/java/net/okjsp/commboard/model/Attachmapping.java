package net.okjsp.commboard.model;

public class Attachmapping {
	//게시판 번호
	private int boardId;
	//글 번호
	private int writeNo;
	//코멘트 번호
	private int commentId;
	//첨부파일 아이디
	private int attachId;
	//첨부파일 순서
	private int attachOrder;
	
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
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
	public int getAttachId() {
		return attachId;
	}
	public void setAttachId(int attachId) {
		this.attachId = attachId;
	}
	public int getAttachOrder() {
		return attachOrder;
	}
	public void setAttachOrder(int attachOrder) {
		this.attachOrder = attachOrder;
	}

	
}
