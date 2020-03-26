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
    private String username;
    private String password;
    private String salt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
