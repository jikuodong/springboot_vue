package com.jkd.springbootproject.mapper;

import com.jkd.springbootproject.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @projectName: springbootproject
 * @package: com.jkd.springbootproject.mapper
 * @className: UserMapper
 * @author: JKD
 * @description:
 * @date: 2020/3/26 14:12
 * @version: 1.0
 */
@Component
public interface UserMapper {

    User selectUser(User user);

    User isExist(String username);

    String getRid(String username);

    void add(User user);
}
