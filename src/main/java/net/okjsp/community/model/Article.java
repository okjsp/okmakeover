package net.okjsp.community.model;

import net.okjsp.user.model.User;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Article {

	// 게시판 ID
	private int boardId;
	
	// 하위 카테고리명
	private int categoryId;
	
	// 사용여부
	private boolean enabled;
	
	// 공통 글번호
	private int writeNo;
	
	// 회원 아이디
	private int userId;
	
	// 제목
    @NotBlank
	private String title;
	
	//익명글 체크
	private boolean anonymized;
	
	//익명글 닉네임
	private String anonymousNickname;
	
	// 내용
	private String content;
	
	// 조회수
	private int postingHit;
	
	// 작성일시
	private Date writeDate;
	
	// 업데이트 일시
	private Date updateDate;
	
	//작성자
	private User user;

    private int commentCount;

    private List<Comment> comments;

    //TODO: 첨부파일

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

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getWriteNo() {
		return writeNo;
	}

	public void setWriteNo(int writeNo) {
		this.writeNo = writeNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public boolean getAnonymized() {
		return anonymized;
	}

	public void setAnonymized(boolean anonymized) {
		this.anonymized = anonymized;
	}

	public String getAnonymousNickname() {
		return anonymousNickname;
	}

	public void setAnonymousNickname(String anonymousNickname) {
		this.anonymousNickname = anonymousNickname;
	}


    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getNickname() {
        if(getAnonymized()) {
            return getAnonymousNickname();
        } else {
            User user = getUser();
            if(user != null) {
                return user.getNickName();
            } else {
                return "";
            }
        }
    }

    public String getProfileImg() {
        if(!getAnonymized()) {
            User user = getUser();
            if(user != null) {
                return user.getProfileImg();
            }
        }
        return "";
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
