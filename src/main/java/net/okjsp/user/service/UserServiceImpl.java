package net.okjsp.user.service;

import net.okjsp.user.dao.UserDao;
import net.okjsp.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * User: langerhans
 * Date: 2014. 1. 3.
 * Time: 오후 3:49
 * Description : UserServiceImpl
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    @Autowired
    private ShaPasswordEncoder shaPasswordEncoder;

    @Autowired
    private SaltSource saltSource;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.selectOneByEmail(username);

        if(user == null) {
            throw new UsernameNotFoundException("이메일주소 또는 비밀번호를 확인하고 다시 로그인해 주세요.");
        }

        Collection<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        user.setAuthorities(authorities);

        return user;
    }

    @Override
    public boolean create(User user) throws Exception {

        if(checkDuplicateEmail(user.getEmail())) {
            throw new Exception("이이 사용중인 이메일 입니다.");
        }

        if(checkDuplicateNickName(user.getNickName())) {
            throw new Exception("이미 사용중인 닉네임 입니다.");
        }

        String encPassword = shaPasswordEncoder.encodePassword(user.getPassword(), saltSource.getSalt(user));
        user.setPassword(encPassword);

        int count = userDao.insert(user);

        return count > 0;
    }

    @Override
    public User getOneByEmail(String email) {
        return userDao.selectOneByEmail(email);
    }

    @Override
    public boolean checkDuplicateEmail(String email) {
        return userDao.selectCountByEmail(email) > 0;
    }

    @Override
    public boolean checkDuplicateNickName(String nickName) {
        return userDao.selectCountByNickName(nickName) > 0;
    }

    @Override
    public User getOne(int userId) {
        return null;
    }

    @Override
    public boolean modify(User user) {
        return false;
    }

    @Override
    public boolean destroy(int userId) {
        return false;
    }
}
