package cn.tedu.springboot.service;

import cn.tedu.springboot.entity.User;

public interface IUserService {
    /**
     * 查询用户名是否存在
     * @param username  用户名
     * @return          存在返回1，不存在返回0；
     */
    public User checkName(String username);

    /**
     * 根据用户邮箱查询用户信息
     * @param email    用户邮箱
     * @return         用户信息
     */
    User checkEmail(String email);

    /**
     * 根据用户手机号查询用户信息
     * @param phone    用户手机号
     * @return         用户信息
     */
    User checkPhone(String phone);

    /**
     * 用户注册
     * @param user  用户提交的注册信息
     * @return      用户id
     */
    Integer register(User user);

    /**
     * 用户登陆
     * @param username      用户名
     * @param password      用户密码
     * @throws RuntimeException  用户姓名密码不匹配异常
     */
    void login(String username,String password);
}
