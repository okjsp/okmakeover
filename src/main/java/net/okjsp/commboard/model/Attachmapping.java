package net.okjsp.commboard.model;

public class Attachmapping {
	//게시판 번호
	private int board_id;
	//글 번호
	private int write_no;
	//코멘트 번호
	private int comment_id;
	//첨부파일 아이디
	private int attach_id;
	//첨부파일 순서
	private int attach_order;
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
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
	public int getAttach_id() {
		return attach_id;
	}
	public void setAttach_id(int attach_id) {
		this.attach_id = attach_id;
	}
	public int getAttach_order() {
		return attach_order;
	}
	public void setAttach_order(int attach_order) {
		this.attach_order = attach_order;
	}
	
	
}
