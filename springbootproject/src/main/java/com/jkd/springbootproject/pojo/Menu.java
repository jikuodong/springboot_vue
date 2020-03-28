package com.jkd.springbootproject.pojo;

import java.io.Serializable;
import java.util.List;


public class Menu implements Serializable,Cloneable{
    /** 菜单表id */
    private Integer id ;
    /** 前端路由的访问路径 */
    private String path ;
    /** 菜单名 */
    private String name ;
    /** 菜单中文名 */
    private String nameZh ;
    /** 菜单图标 */
    private String icon ;
    /** 前端路由所在的组件位置 */
    private String component ;
    /** 父菜单 */
    private Integer parentId ;
    private List< Menu> child ;

    public List<Menu> getChild() {
        return child;
    }

    public void setChild(List<Menu> child) {
        this.child = child;
    }

    /** 菜单表id */
    public Integer getId(){
        return this.id;
    }
    /** 菜单表id */
    public void setId(Integer id){
        this.id = id;
    }
    /** 前端路由的访问路径 */
    public String getPath(){
        return this.path;
    }
    /** 前端路由的访问路径 */
    public void setPath(String path){
        this.path = path;
    }
    /** 菜单名 */
    public String getName(){
        return this.name;
    }
    /** 菜单名 */
    public void setName(String name){
        this.name = name;
    }
    /** 菜单中文名 */
    public String getNameZh(){
        return this.nameZh;
    }
    /** 菜单中文名 */
    public void setNameZh(String nameZh){
        this.nameZh = nameZh;
    }
    /** 菜单图标 */
    public String getIcon(){
        return this.icon;
    }
    /** 菜单图标 */
    public void setIcon(String icon){
        this.icon = icon;
    }
    /** 前端路由所在的组件位置 */
    public String getComponent(){
        return this.component;
    }
    /** 前端路由所在的组件位置 */
    public void setComponent(String component){
        this.component = component;
    }
    /** 父菜单 */
    public Integer getParentId(){
        return this.parentId;
    }
    /** 父菜单 */
    public void setParentId(Integer parentId){
        this.parentId = parentId;
    }
}
