package com.zhuzs.admin.mapper;

import com.zhuzs.admin.entity.domain.PermissionDO;
import com.zhuzs.admin.entity.domain.UserDO;

/**
 * 
 * 
 * @author zhu_zishuang
 * @date 2021-03-12
 */
public interface UserMapper {

    /**
     * 查询单个用户
     *
     * @param name
     * @return 单个用户
     */
    UserDO getUser(String name);

    /**
     * 查询用户角色
     *
     * @param name
     * @return 用户角色
     */
    PermissionDO getPermission(String name);
}

