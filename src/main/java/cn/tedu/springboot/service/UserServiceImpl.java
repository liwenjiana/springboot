package cn.tedu.springboot.service;

import cn.tedu.springboot.entity.User;
import cn.tedu.springboot.repository.UserRepository;
import cn.tedu.springboot.service.ex.NotFindException;
import cn.tedu.springboot.service.ex.PasswordNotMatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkName(String username){
         return userRepository.findByUsername(username);
    }

    @Override
    public User checkEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User checkPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public Integer register(User user) {
         userRepository.save(user);
         Integer id=user.getId();
         return id;
    }

    @Override
    public void login(String username, String password) {
        User user=userRepository.findByUsername(username);
        System.out.println(user);
        if(user==null){
            throw new NotFindException("用户名不存在");
        }
        if(!user.getPassword().equals(password)){
            throw new PasswordNotMatchException("用户名和密码不匹配");
        }
    }

}
