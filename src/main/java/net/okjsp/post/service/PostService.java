package net.okjsp.post.service;

import java.util.List;

import net.okjsp.common.model.Paging;
import net.okjsp.post.model.Post;



public interface PostService {

	/**
	 * 쪽지 보내기
	 * 
	 * @param fromPost
	 * @param toPost
	 * @return
	 */
	public boolean addPost(Post fromPost, Post toPost);
	
	/**
	 * 쪽지 읽기
	 * 
	 * @param postId
	 * @param userId
	 * @param postSeq
	 * @param postStatus
	 * @return
	 */
	public boolean modifyPost(String postId, String userId, String postSeq, String postStatus);
	
	/**
	 * 쪽지 삭제
	 * 
	 * @param postId
	 * @param userId
	 * @param postSeq
	 * @return
	 */
	public boolean removePost(String postId, String userId, String postSeq);
	/**
	 * 쪽지 목록 가져오기
	 * 
	 * @param userId
	 * @param postType
	 * @param paging
	 * @return
	 */
	public List<Post> getPostList(String userId, String postType, Paging paging);
	
	/**
	 * 보낸쪽지(받은쪽지) 갯수
	 * 
	  @param userId 사용자 ID
	 * @param postType 쪽지 타입
	 * @return
	 */
	public int getPostTotalCount(String userId, String postType);
	
	/**
	 * 하나의 묶음 (마스터 번호 기준) 쪽지 정보 가져오기.
	 * 
	 * @param postId
	 * @param userId
	 * @return
	 */
	public List<Post> getPostDetailList(String postId, String userId);
}
