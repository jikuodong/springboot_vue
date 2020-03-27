package com.jkd.springbootproject.Realm;

import com.jkd.springbootproject.pojo.User;
import com.jkd.springbootproject.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @projectName: springbootproject
 * @package: com.jkd.springbootproject.Realm
 * @className: UserRealm
 * @author: JKD
 * @description: 用户信息处理
 *               所有自定义的Realm必须继承AuthorizingRealm
 * @version: 1.0
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;



    /**
     * 对登录用户的授权，现在我们先不写
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 此部分处理登录
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // token由控制层传入，获取token中存储的用户名
        String username = authenticationToken.getPrincipal().toString();
        // 根据用户名去数据库查询是否存在该用户
        User user = userService.getUserByName(username);
        if (user == null){
            // 用户不存在抛出不存在异常交给控制层处理
            throw new UnknownAccountException();
        }
        String password = user.getPassword();
        String salt = user.getSalt();
        // 再次把salt转成byte将整个认证交给SecurityManage
        return new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes(salt), getName());
    }
}
