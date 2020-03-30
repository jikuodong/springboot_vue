package com.jkd.springbootproject.mapper;

import com.jkd.springbootproject.pojo.Menu;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @projectName: springbootproject
 * @package: com.jkd.springbootproject.mapper
 * @className: UserAuthMapper
 * @author: JKD
 * @description: 用户菜单权限
 * @date: 2020/3/28 16:41
 * @version: 1.0
 */
@Component
public interface UserAuthMapper {
    List<Menu> getByParentId(Integer rid, Integer parentId);

    List<Menu> getUserMenu(Integer rid);

    List<Menu> getAllMenu();

    List<Integer> getParentMenuId();

    List<Menu> getByPid(Integer id);


}
