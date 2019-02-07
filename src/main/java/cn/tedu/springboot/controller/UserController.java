package cn.tedu.springboot.controller;

import cn.tedu.springboot.bean.ResposeResult;
import cn.tedu.springboot.entity.User;
import cn.tedu.springboot.service.IUserService;
import cn.tedu.springboot.service.ex.NotFindException;
import cn.tedu.springboot.service.ex.PasswordNotMatchException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    IUserService userService;

    @RequestMapping("/login.do")
    public String showLogin(){
        return "login";
    }

    @RequestMapping("/register.do")
    public String showRegister(){
        return "register";
    }

    @RequestMapping(value="/checkName.do" ,produces = "application/json;charset=UTF-8" ,method= RequestMethod.POST)
    @ResponseBody
    public ResposeResult<Void>  checkName(String username){
        User user=userService.checkName(username);
        System.out.println(user);
        ResposeResult<Void>  result=new ResposeResult<Void>(0,"用户名可以使用");;
        if(user!=null){
            result.setState(1);
            result.setMessage("用户名已存在");
        }
       return result;
    }

    @RequestMapping(value="/checkEmail.do" ,produces = "application/json;charset=UTF-8" ,method= RequestMethod.POST)
    @ResponseBody
    public ResposeResult<Void>  checkEmail(String email){
        User user=userService.checkEmail(email);
        ResposeResult<Void>  result=new ResposeResult<Void>(0,"用户邮箱可以使用");;
        if(user!=null){
            result.setState(1);
            result.setMessage("用户邮箱已存在");
        }
        return result;
    }

    @RequestMapping(value="/checkPhone.do" ,produces = "application/json;charset=UTF-8" ,method= RequestMethod.POST)
    @ResponseBody
    public ResposeResult<Void>  checkPhone(String phone){
        User user=userService.checkPhone(phone);
        ResposeResult<Void>  result=new ResposeResult<Void>(0,"用户手机号可以使用");;
        if(user!=null){
            result.setState(1);
            result.setMessage("用户手机号已存在");
        }
        return result;
    }

    @RequestMapping(value="/reg.do" ,produces = "application/json;charset=UTF-8" ,method= RequestMethod.POST)
    @ResponseBody
    public ResposeResult<Void> handleReg(User user){
        Integer id=userService.register(user);
        if(id!=null)
            return new ResposeResult<Void>(1,"注册成功");
        return new ResposeResult<Void>(0,"注册失败");
    }
    @RequestMapping(value="/handleLogin.do" ,produces = "application/json;charset=UTF-8" ,method= RequestMethod.POST)
    @ResponseBody
    public ResposeResult<Void> handleLogin(String username,String password){
        ResposeResult<Void> result=new ResposeResult<Void>(1,"登陆成功");
        try {
            userService.login(username,password);
        } catch (NotFindException e) {
            result.setState(0);
            result.setMessage(e.getMessage());
        }catch(PasswordNotMatchException e){
            result.setState(0);
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
