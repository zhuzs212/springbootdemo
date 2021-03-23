package com.zhuzs.admin.config;

import com.zhuzs.admin.entity.domain.UserDO;
import com.zhuzs.admin.exception.ServiceException;
import com.zhuzs.admin.comm.SysExceptionEnum;
import com.zhuzs.admin.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * shiro 自定义realm
 *
 * @author zhu_zishuang
 * @date 2021-03-12
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        // 判断用户名是否为空
        if (StringUtils.isEmpty(username)) {
            throw new ServiceException(SysExceptionEnum.ACCOUNT_IS_EMPTY);
        }

        UserDO userDO = userService.getUser(username);
        if (ObjectUtils.isEmpty(userDO)) {
            // userDO为null,抛出自定义异常
            throw new ServiceException(SysExceptionEnum.ACCOUNT_NOT_EXIST);
        }

        // 存入 Session，可选
        SecurityUtils.getSubject().getSession().setAttribute("user", userDO);
        return new SimpleAuthenticationInfo(userDO, userDO.getPassword(), getName());

    }

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
}