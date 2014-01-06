package net.okjsp.user.service;

import net.okjsp.user.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * User: langerhans
 * Date: 2014. 1. 3.
 * Time: 오후 3:10
 * Description : UserService
 */
public interface UserService extends UserDetailsService {

    /**
     * Spring Security 연동을 위한 UserDetailsService Override
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    /**
     * 회원 생성
     * @param user
     * @return
     */
    public boolean create(User user) throws Exception;

    /**
     * 이메일로 회원 정보 가져오기
     * @param email
     * @return
     */
    public User getOneByEmail(String email);

    /**
     * 이메일 주소 중복 검사
     * @param email
     * @return
     */
    public boolean checkDuplicateEmail(String email);

    /**
     *
     * @param nickName
     * @return
     */
    public boolean checkDuplicateNickName(String nickName);

    /**
     * 회원 정보 가져오기
     * @param userId
     * @return
     */
    public User getOne(int userId);

    /**
     * 회원 정보 수정
     * @param user
     * @return
     */
    public boolean modify(User user);

    /**
     * 회원 정보 삭제
     * @param userId
     * @return
     */
    public boolean destroy(int userId);
}
