package com.jkd.springbootproject.service;

import com.jkd.springbootproject.mapper.UserAuthMapper;
import com.jkd.springbootproject.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @projectName: springbootproject
 * @package: com.jkd.springbootproject.service
 * @className: UserAuthService
 * @author: JKD
 * @description: 对返回的菜单进行处理
 * @version: 1.0
 */
@Service
public class UserAuthService {

    @Autowired
    private UserAuthMapper userAuthMapper;

    public List<Menu> getByChildMenu(Integer rid, Integer parentId) {
        return userAuthMapper.getByParentId(rid,parentId);
    }

    public List<Menu> getUserMenu(Integer rid) {
        return userAuthMapper.getUserMenu(rid);
    }


    public Map<String,List> getAllMenu(){
        Map<String,List> result = new HashMap<>();
        List<Menu> noParentMenu = userAuthMapper.getAllMenu();
        result.put("noParent",menuManage(noParentMenu));
        result.put("parent",userAuthMapper.getParentMenuId());
        return result;
    }

    private List menuManage(List<Menu> menus) {//对菜单进行格式化
        for(Menu menu : menus){
            menu.setChild(userAuthMapper.getByPid(menu.getId()));
        }
        Iterator<Menu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            Menu menu = iterator.next();
            if (menu.getParentId() != 0) {
                iterator.remove();
            }
        }
        return menus;
    }

}

