package com.ityun.shiro;

import com.ityun.bean.User;
import com.ityun.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Realm
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 授权逻辑（权限验证）
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权逻辑");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        //查询权限 并授权 （兼容多个权限节点） 同样角色的问题也不过是 user->role->perms。逐个进行授权即可
        User perms = userService.findById(user.getId());
        if (perms.getPerms() != null) {
            String[] auths = perms.getPerms().split("#");
            for (String auth : auths) {
                info.addStringPermission(auth);
            }
        } else {
            info.addStringPermission(null);
        }
        return info;
    }

    /**
     * 认证逻辑（登陆验证）
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证逻辑");

        //Shiro判断逻辑
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.findByName(token.getUsername());

        if (user == null) {
            return null;//底层会抛出UnKnowAccountException
        }

        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
