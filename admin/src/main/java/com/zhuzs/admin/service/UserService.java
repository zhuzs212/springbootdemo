package com.zhuzs.admin.service;

import com.zhuzs.admin.entity.domain.PermissionDO;
import com.zhuzs.admin.entity.domain.UserDO;

/**
 * 用户接口
 *
 * @Author zhu_zishuang
 * @Date 2020-09-17
 */
public interface UserService {

    /**
     * 查询单个用户
     *
     * @param name
     * @return 单个用户
     */
    UserDO getUser(String name);

    /**
     * 查询用户角色信息
     *
     * @param name
     * @return 用户角色信息
     */
    PermissionDO getPermission(String name);
}
