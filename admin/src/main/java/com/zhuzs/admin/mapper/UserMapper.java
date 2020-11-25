package com.zhuzs.admin.mapper;

import com.zhuzs.admin.entity.domain.PermissionDO;
import com.zhuzs.admin.entity.domain.UserDO;

/**
 * @description：
 * @author: zhu_zishuang
 * @date: 2020-04-26 08:29
 */
public interface UserMapper {

    /**
     * @param name
     * @return
     */
    UserDO getUser(String name);

    /**
     * @param name
     * @return
     */
    PermissionDO getPermission(String name);
}

