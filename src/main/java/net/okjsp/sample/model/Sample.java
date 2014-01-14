package net.okjsp.sample.model;

import net.okjsp.user.model.User;

import java.util.Date;

/**
 * User: langerhans
 * Date: 2013. 11. 20.
 * Time: 오전 12:27
 * Description : 샘플 게시판 Model
 */

public class Sample {

    int id;
    int categoryId;
    String title;
    String content;
    int viewCount;
    Date writeDate;
    int writeId;
    Date updateDate;
    int updateId;

    User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
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

    public int getWriteId() {
        return writeId;
    }

    public void setWriteId(int writeId) {
        this.writeId = writeId;
    }

    public int getUpdateId() {
        return updateId;
    }

    public void setUpdateId(int updateId) {
        this.updateId = updateId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
