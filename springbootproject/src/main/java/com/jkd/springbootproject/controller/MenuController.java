package com.jkd.springbootproject.controller;

import com.jkd.springbootproject.pojo.Menu;
import com.jkd.springbootproject.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private UserAuthService userAuthService;

    @GetMapping("/get/{rid}")
    public List<Menu> getMenu(@PathVariable Integer rid){
        List<Menu> menus = userAuthService.getUserMenu(rid);
        for(Menu menu : menus){
            if(menu.getParentId() == 0) {
                menu.setChild(userAuthService.getByChildMenu(rid,menu.getId()));
            }
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

    @GetMapping("/all")
    public Map<String,List> getAllMenu(){
        return userAuthService.getAllMenu();
    }
}
