package net.okjsp.community.model;

import net.okjsp.user.model.User;

public class Comment {
	//게시판 번호
	private String boardId;
	//글 번호
	private String writeNo;
	//코멘트 번호
	private String commentId;
	//본문
	private String content;
    //작성자 id
    private int userId;
	//올린 시간
	private String writeDate;
	//수정 시간
	private String updateDate;
    //작성자
    private User user;

	
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getWriteNo() {
		return writeNo;
	}
	public void setWriteNo(String writeNo) {
		this.writeNo = writeNo;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
