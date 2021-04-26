package com.jkd.springbootproject.exceptionhandler;

import com.alibaba.fastjson.JSONObject;

/**
 * @projectName: springbootproject
 * @package: com.jkd.springbootproject.exceptionhandler
 * @className: User
 * @author: JKD
 * @description: 实体类
 * @version: 1.0
 */
public class User {

    /** 编号 */
    private int id;
    /** 姓名 */
    private String name;
    /** 年龄 */
    private int age;

    public User(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
