package com.jkd.springbootproject.controller;

import com.jkd.springbootproject.mapper.UserMapper;
import com.jkd.springbootproject.pojo.User;
import com.jkd.springbootproject.service.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String Login(@RequestBody User user){
        User u = userMapper.selectUser(user);
        if (u !=null ){
            return "验证成功";
        }
        return "登验证失败";
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
