package com.jkd.springbootproject.service;

import com.jkd.springbootproject.mapper.UserMapper;
import com.jkd.springbootproject.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName: springbootproject
 * @package: com.jkd.springbootproject.service
 * @className: UserService
 * @author: JKD
 * @description: 用户service层
 * @version: 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean checkUser(User user){
        User u = userMapper.selectUser(user);
        if (u == null) {
            // 如果账号面输入不正确，返回false
            return false;
        }
        return true;
    }

    public boolean isExist(String username){
        User user = userMapper.isExist(username);
        // 从数据库可以查找出用户
        if (user != null){
            return true;
        }
        return false;
    }

    public void add(User user){
        userMapper.add(user);
    }
}
