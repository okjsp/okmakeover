package net.okjsp.commboard.service;

import java.util.List;

import net.okjsp.commboard.model.Comment;
import net.okjsp.common.model.Paging;

public interface CommentService {

    public List<Comment> getList( 
    		String boardNo,
            String writeNo,
            String searchflg,
            String search,
            String sort,
            Paging paging);

    public int getTotalCount(
    		String boardNo,
            String writeNo);

    public Comment getOne(
    		String boardNo,
            String writeNo,
            String commentId);

    public boolean create(Comment comment);
    
    public boolean modify(Comment comment);
    
    public boolean destroy(Comment comment);
 

}
