package com.jkd.springbootproject.pojo;

import org.springframework.data.annotation.Id;

import java.io.Serializable;


public class Role implements Serializable,Cloneable{
    /** 角色id */
    private Integer id ;
    /** 角色名 */
    private String name ;
    /** 角色中文名 */
    private String nameZh ;

    /** 角色id */
    public Integer getId(){
        return this.id;
    }
    /** 角色id */
    public void setId(Integer id){
        this.id = id;
    }
    /** 角色名 */
    public String getName(){
        return this.name;
    }
    /** 角色名 */
    public void setName(String name){
        this.name = name;
    }
    /** 角色中文名 */
    public String getNameZh(){
        return this.nameZh;
    }
    /** 角色中文名 */
    public void setNameZh(String nameZh){
        this.nameZh = nameZh;
    }
}
