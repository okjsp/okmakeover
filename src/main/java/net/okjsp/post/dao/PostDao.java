/**
 * 
 */
package net.okjsp.post.dao;

import java.util.List;

import net.okjsp.post.model.Post;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 쪽지 (보내기/받기/읽기/삭제) DAO
 * 
 * @author choong83
 *
 */
@Repository
public interface PostDao {

	/**
	 * 보낸쪽지(받은쪽지) 목록 가져오기
	 * 
	 * @param userId 사용자 ID
	 * @param postType 쪽지 타입
	 * @param offset 
	 * @param sizePerList 
	 * 
	 * @return
	 */
	public List<Post> selectPostList(@Param("userId") String userId, @Param("postType") String postType, 
			@Param("offset") int offset, @Param("sizePerList") int sizePerList );
	/**
	 * 보낸쪽지(받은쪽지) 갯수
	 * 
	  @param userId 사용자 ID
	 * @param postType 쪽지 타입
	 * @return
	 */
	public int selectPostTotalCount(@Param("userId") String userId, @Param("postType") String postType);
	/**
	 * 쪽지 보내기
	 * 
	 * @param post
	 * @return
	 */
	public int insertPost(Post post);
	
	/**
	 * 하나의 묶음 (마스터 번호 기준) 쪽지 정보 가져오기.
	 * 
	 * @param postId 쪽지 마스터 ID
	 * @param userId 사용자 ID
	 * @return
	 */
	public List<Post> selectPostDetailList( @Param("postId") String postId, @Param("userId") String userId);
	
	/**
	 * 쪽지 삭제 
	 * 
	 * @param postId
	 * @param userId
	 * @param postSeq
	 * @return
	 */
	public int deletePost(@Param("postId") String postId, @Param("userId") String userId, @Param("postSeq") String postSeq);
	
	/**
	 * 쪽지 읽음
	 * 
	 * @param postId 쪽지 마스터 ID
	 * @param userId 사용자 ID
	 * @param postSeq 쪽지 순번
	 * @param postStatus 쪽지 상태
	 * @return
	 */
	public int updatePost(@Param("postId") String postId, @Param("userId") String userId, @Param("postSeq") String postSeq, 
			@Param("postStatus") String postStatus);
}
