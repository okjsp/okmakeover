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
     * 로그인 아이디로 회원 정보 가져오기
     * @param loginId
     * @return
     */
    public User selectOneByLoginId(@Param("loginId") String loginId);

    /**
     * 로그인 아이디 카운트
     * @param loginId
     * @return
     */
    public int selectCountByLoginId(@Param("loginId") String loginId);

    /**
     * 이메일 카운트
     * @param email
     * @return
     */
    public int selectCountByEmail(@Param("email") String email);

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
    public boolean insert(User user);

    /**
     * 회원 정보 수정
     * @param user
     * @return
     */
    public boolean update(User user);

    /**
     * 회원 정보 삭제
     * @param userId
     * @return
     */
    public boolean updateDelDate(@Param("userId") int userId);
}
