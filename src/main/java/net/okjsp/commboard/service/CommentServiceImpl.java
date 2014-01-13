package net.okjsp.commboard.service;

import java.util.List;

import net.okjsp.commboard.dao.CommentDao;
import net.okjsp.commboard.model.Comment;
import net.okjsp.common.model.Paging;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService  {
	
	   Logger logger = Logger.getLogger(this.getClass());
	   
	    @Autowired
	    CommentDao commentDao;

    public List<Comment> getList( 
    		String boardNo,
            String writeNo,
            String searchflg,
            String search,
            String sort,
            Paging paging) {
    
    	 List<Comment> list = commentDao.selectList(boardNo,writeNo,searchflg, search, sort, paging.getOffset(), paging.getSizePerList());

         return list;
    }

    public int getTotalCount(
    		String boardNo,
            String writeNo){
    	
    	
    	return commentDao.selectTotalCount(boardNo, writeNo);
    }

    public Comment getOne(
    		String boardNo,
            String writeNo,
            String commentId) {
    	
    	 
    	
    	return commentDao.selectOne(boardNo, writeNo, commentId);
    }

    public boolean create(Comment comment){
        boolean result = false;

        int count = commentDao.insert(comment);

        if(count > 0) {
            result = true;
        }

        return result;
    }

    
    public boolean modify(Comment comment){
    	
        boolean result = false;

        int count = commentDao.update(comment);

        if(count > 0) {
            result = true;
        }

        return result;
    }

    
    public boolean destroy(Comment comment){
     
        boolean result = false;

        int count = commentDao.delete(comment.getBoardNo(),comment.getWriteNo(),comment.getCommentId());

        if(count > 0) {
            result = true;
        }

        return result;
    }

 

}
