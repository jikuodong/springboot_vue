package com.jkd.springbootproject.controller;

import com.jkd.springbootproject.pojo.User;
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

    @PostMapping("/login")
    public String Login(@RequestBody User user){
        if (user.getUserName().equals("user") && user.getPassword().equals("password")){
            return "登录成功";
        }
        return "登录失败";
    }
}
