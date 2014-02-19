/**
 * 
 */
package net.okjsp.post.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.okjsp.common.model.Paging;
import net.okjsp.post.dao.PostDao;
import net.okjsp.post.model.Post;

/**
 * 쪽지 (보내기/받기/읽기/삭제) Service
 * 
 * @author choong83
 *
 */
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;
	
	/* (non-Javadoc)
	 * @see net.okjsp.post.service.PostService#addPost(net.okjsp.post.model.Post, net.okjsp.post.model.Post)
	 */
	@Override
	public boolean addPost(Post fromPost, Post toPost) {
		long postId = getUniquePostId();
		
		fromPost.setPostId(postId);
		toPost.setPostId(postId);
		postDao.insertPost(fromPost);
		postDao.insertPost(toPost);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see net.okjsp.post.service.PostService#modifyPost(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean modifyPost(String postId, String userId, String postSeq, String postStatus) {
		postDao.updatePost(postId, userId, postSeq, postStatus);
		return true;
	}

	/* (non-Javadoc)
	 * @see net.okjsp.post.service.PostService#removePost(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean removePost(String postId, String userId, String postSeq) {
		postDao.deletePost(postId, userId, postSeq);
		return true;
	}

	
	/* (non-Javadoc)
	 * @see net.okjsp.post.service.PostService#getPostList(java.lang.String, java.lang.String, net.okjsp.common.model.Paging)
	 */
	@Override
	public List<Post> getPostList(String userId, String postType, Paging paging) {
		
		return postDao.selectPostList(userId, postType, paging.getOffset(), paging.getSizePerList());
	}

	
	/* (non-Javadoc)
	 * @see net.okjsp.post.service.PostService#getPostTotalCount(java.lang.String, java.lang.String)
	 */
	@Override
	public int getPostTotalCount(String userId, String postType) {
		
		return postDao.selectPostTotalCount(userId, postType);
	}

	/* (non-Javadoc)
	 * @see net.okjsp.post.service.PostService#getPostDetailList(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Post> getPostDetailList(String postId, String userId) {

		return postDao.selectPostDetailList(postId, userId);
	}

	private long getUniquePostId(){
		long timeStamp = System.nanoTime();
		
		Random rand = new Random();
		int randInt = rand.nextInt(999999);
		String randVal = String.format("%06d",randInt);
		
		long result = Long.valueOf(String.valueOf(timeStamp) + randVal); 
		
		return result;
	}
}
