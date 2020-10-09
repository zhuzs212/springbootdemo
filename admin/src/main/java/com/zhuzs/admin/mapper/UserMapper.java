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
     * @param userName
     * @return
     */
    UserDO getUser(String userName);

    /**
     * @param userName
     * @return
     */
    PermissionDO getPermission(String userName);
}

