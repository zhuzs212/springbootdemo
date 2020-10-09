package com.zhuzs.admin.config;

import com.zhuzs.admin.entity.domain.UserDO;
import com.zhuzs.admin.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhu_zishuang
 * @date: 2020-10-09
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取当前登录对象
        Subject subject = SecurityUtils.getSubject();
        UserDO userDO = (UserDO) subject.getPrincipal();

        //设置角色
        Set<String> roles = new HashSet<>();
        roles.add(userDO.getRoleDO().getRoleName());

        //设置权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo(roles);
        authorizationInfo.addStringPermission(userService.getPermission(userDO.getName()).getPermissionName());

        return authorizationInfo;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserDO userDO = userService.getUser(token.getUsername());
        if (userDO != null) {
            // 存入 Session，可选
            SecurityUtils.getSubject().getSession().setAttribute("user", userDO);
            return new SimpleAuthenticationInfo(userDO, userDO.getPassword(), getName());
        }
        return null;
    }
}