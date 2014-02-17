package net.okjsp.community.service;

import java.util.List;

import net.okjsp.community.model.Comment;
import net.okjsp.common.model.Paging;

public interface CommentService {

    public List<Comment> getList(
            int boardNo,
            int writeNo,
            String searchflg,
            String search,
            String sort,
            Paging paging);

    public int getTotalCount(
            int boardNo,
            int writeNo);

    public Comment getOne(
            int boardNo,
            int writeNo,
            int commentId);

    public boolean create(Comment comment);
    
    public boolean modify(Comment comment);
    
    public boolean destroy(Comment comment);
 

}
