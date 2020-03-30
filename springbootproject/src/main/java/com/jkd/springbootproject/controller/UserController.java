package com.jkd.springbootproject.controller;

import com.jkd.springbootproject.mapper.UserMapper;
import com.jkd.springbootproject.pojo.User;
import com.jkd.springbootproject.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: springbootproject
 * @package: com.jkd.springbootproject.UserController
 * @className: UserController
 * @author: JKD
 * @description: 用户信息控制层
 * @date: 2020/3/24 16:14
 * @version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserMapper userMapper;
    private UserService userService;

    @Autowired
    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @PostMapping("/login")
    public Object Login(@RequestBody User user){
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject);
        // Shiro帮我们写好了usernamePasswordToken，只要提交账号密码，后面的交给Realm,Realm交给SecurityManage
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        System.out.println(token);
        // 只要一行代码就能实现登录
        try {
            subject.login(token);
            String rid = userService.getRid(user.getUsername());
            Map<String, String> map = new HashMap<>();
            map.put("token", (String) subject.getSession().getId());
            map.put("rid", rid);
            return map;
        }catch (UnknownAccountException e){ // 处理我们在Realm中抛出的异常
            return "用户不存在";
        } catch (AuthenticationException e) { // 当Shiro发现用户的账号密码不匹配时自动抛出这个异常
            return "账号或密码错误";
        }
    }

    @PostMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "登出成功";
    }

    @GetMapping("/getAuth")
    public Integer isAuth() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return 1;
        }
        return 0;
    }

    // 用户注册

    @PostMapping("register")
    public String register(@RequestBody User user){
        System.out.println(user.getUsername());
        if (userService.isExist(user.getUsername())){
            return "用户名已存在";
        }
        // 根据用户名生成盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 根据生成的盐和用户输入的密码迭代2次生成新的密码
        String newPasswoed = new SimpleHash("md5",user.getPassword(),salt,2).toString();
        // 存储用户信息，包括salt与hash后的密码
        user.setSalt(salt);
        user.setPassword(newPasswoed);
        userService.add(user);
        return "注册成功";
    }
}
