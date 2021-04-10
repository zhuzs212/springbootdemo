package com.zhuzs.admin.service;

import com.zhuzs.admin.entity.domain.PermissionDO;
import com.zhuzs.admin.entity.domain.UserDO;
import com.zhuzs.admin.entity.request.LoginUserRequest;

import java.util.Map;

/**
 * 用户接口
 *
 * @author zhu_zishuang
 * @date 2020-09-17
 */
public interface UserService {

    /**
     * 登录
     *
     * @param request 登陆请求入参
     * @return token
     */
    Map<String, String> login(LoginUserRequest request);

    /**
     * 查询单个用户
     *
     * @param name 用户名
     * @return 单个用户
     */
    UserDO getUser(String name);

    /**
     * 查询用户角色信息
     *
     * @param name 用户名
     * @return 用户角色信息
     */
    PermissionDO getPermission(String name);
}
