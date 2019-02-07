package cn.tedu.springboot.repository;

import cn.tedu.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * 根据用户名查询用户信息
     * @param username   用户名
     * @return           用户信息
     */
    User findByUsername(String username);

    /**
     * 根据用户邮箱查询用户信息
     * @param email    用户邮箱
     * @return         用户信息
     */
    User findByEmail(String email);

    /**
     * 根据用户手机号查询用户信息
     * @param phone    用户手机号
     * @return         用户信息
     */
    User findByPhone(String phone);

}
