package com.jkd.springbootproject.pojo;

/**
 * @projectName: springbootproject
 * @package: com.jkd.springbootproject.pojo
 * @className: User
 * @author: JKD
 * @description: 用户信息类
 * @date: 2020/3/24 15:30
 * @version: 1.0
 */
public class User {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
