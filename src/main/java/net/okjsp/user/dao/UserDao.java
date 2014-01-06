package net.okjsp.user.dao;

import net.okjsp.user.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * User: langerhans
 * Date: 2014. 1. 2.
 * Time: 오전 10:23
 * Description : UserDao
 */
@Repository
public interface UserDao {

    /**
     * 이메일로 회원 정보 가져오기
     * @param loginId
     * @return
     */
    public User selectOneByEmail(@Param("email") String loginId);

    /**
     * 이메일 카운트
     * @param email
     * @return
     */
    public int selectCountByEmail(@Param("email") String email);

    /**
     * 닉네임 카운트
     * @param nickName
     * @return
     */
    public int selectCountByNickName(@Param("nickName") String nickName);

    /**
     * 회원 정보 가져오기
     * @param userId
     * @return
     */
    public User selectOne(@Param("userId") int userId);

    /**
     * 회원 등록
     * @param user
     * @return
     */
    public int insert(User user);

    /**
     * 회원 정보 수정
     * @param user
     * @return
     */
    public int update(User user);

    /**
     * 회원 정보 삭제
     * @param userId
     * @return
     */
    public int updateDelDate(@Param("userId") int userId);
}
