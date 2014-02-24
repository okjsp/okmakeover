package net.okjsp.techqna.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.okjsp.community.model.Comment;
import net.okjsp.recommendation.model.BoardRecommend;
import net.okjsp.recommendation.model.BoardRecommendOperator;
import net.okjsp.tag.model.Tag;
import net.okjsp.user.model.User;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * TechQna Model.
 *
 * @author jaeger
 */
public class TechQna implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 게시물 번호
     */
    private Integer writeNo;

    /**
     * 게시판 ID
     */
    private Integer boardId;

    /**
     * 카테고리 ID
     */
    private Integer categoryId;

    /**
     * 부모 게시물 ID
     */
    private Integer parentId = 0;
    /**
     * 제목
     */
    private String qnaTitle;
    /**
     * 내용
     */
    private String content;
    /**
     * 사용자 ID
     */
    private Integer userId;
	/**
     * 조회수
     */
    private Integer postingHit;
    /**
     * 사용여부
     */
    private boolean enabled;
    /**
     * 작성날짜
     */
    @DateTimeFormat(style = "MM", pattern = "yyyy-MM-dd")
    private Date writeDate;
    /**
     * 수정날짜
     */
    @DateTimeFormat(style = "MM", pattern = "yyyy-MM-dd")
    private Date updateDate;
    /**
     * 추천/신고/반대 연산자
     */
    private BoardRecommendOperator boardRecommendOperator;
    /**
     * comment List
     */
    private List<Comment> commentList;
    /**
     * 태그 리스트
     */
    private List<Tag> tagList;
	/**
	 * 사용자
	 */
	private User user;
	
    /**
     * 게시물 번호 Getter.
     *
     * @return 게시물 번호
     */
    public Integer getWriteNo() {
        return writeNo;
    }

    /**
     * 게시물 번호 Setter.
     *
     * @param writeNo 게시물 번호
     */
    public void setWriteNo(Integer writeNo) {
        this.writeNo = writeNo;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Q/A 구분 Getter.
     *
     * @return 삭제 구분(Y/N)
     */
    public boolean getEnabled() {
        return enabled;
    }

    /**
     * Q/A 구분
     *
     * @param 삭제 구분(Y/N)
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 부모 게시물 ID Getter.
     *
     * @return 부모 게시물 ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 부모 게시물 ID Setter.
     *
     * @param parentId 부모 게시물 ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 제목 Getter.
     *
     * @return 제목
     */
    public String getQnaTitle() {
        return qnaTitle;
    }

    /**
     * 제목 Setter.
     *
     * @param qnaTitle 제목
     */
    public void setQnaTitle(String qnaTitle) {
        this.qnaTitle = qnaTitle;
    }

    /**
     * 내용 Getter.
     *
     * @return 내용
     */
    public String getContent() {
        return content;
    }

    /**
     * 내용 Setter.
     *
     * @param content 내용
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    /**
     * 사용자ID getter
     * 
     * @return
     */
    public Integer getUserId() {
		return userId;
	}

    /**
     * 사용자 ID setter
     * 
     * @param userId
     */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

    /**
     * 조회수 Getter.
     *
     * @return 조회수
     */
    public Integer getPostingHit() {
        return postingHit;
    }

    /**
     * 조회수 Setter.
     *
     * @param postingHit 조회수
     */
    public void setPostingHit(Integer postingHit) {
        this.postingHit = postingHit;
    }

    /**
     * 작성일자 Getter.
     *
     * @return 작성일자
     */
    public Date getWriteDate() {
        return writeDate;
    }

    /**
     * 작성일자 Setter.
     *
     * @param wirteDate 작성일자
     */
    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    /**
     * 수정일자 Getter.
     *
     * @return 수정일자
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 수정일자 Setter.
     *
     * @param updateDate 수정일자
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
   
    /**
     * 추천 리스트 getter
     * 
     * @return 추천 조작자
     */
    public BoardRecommendOperator getBoardRecommendOperator() {
		return boardRecommendOperator;
	}

    /**
     * 추천 리스트 setter
     * 
     * @param boardRecommendList 조작자
     */
	public void setBoardRecommendOperator(BoardRecommendOperator boardRecommendOperator) {
		this.boardRecommendOperator = boardRecommendOperator;
	}
	
	/**
	 * 태그 리스트 getter
	 * 
	 * @return 태그 리스트
	 */
	public List<Tag> getTagList() {
		return tagList;
	}

	/**
	 * 태그 리스트 setter
	 * 
	 * @param tagList 태그 리스트
	 */
	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}
	
	/**
	 * 태그 리스트 setter
	 * 
	 * @param tags 태그들
	 */
	public void setTagList(String... tags) {
		List<Tag> l = new ArrayList<Tag>();
		
		for(String tag : tags) {
			Tag t = new Tag(tag);
			l.add(t);
		}
		this.tagList = l;
	}
	
	/**
	 * comment 리스트 getter
	 * 
	 * @return 태그 리스트
	 */
	public List<Comment> getCommentList() {
		return commentList;
	}
	
	/**
	 * comment 리스트 setter
	 * 
	 * @param tagList 태그 리스트
	 */
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
	/**
	 * 사용자 getter
	 * 
	 * @return 사용자
	 */
	
	
	public User getUser() {
		return user;
	}
	
	/**
	 * 사용자 setter
	 * 
	 * @param user 사용자
	 */
	public void setUser(User user) {
		this.user = user;
	}

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
