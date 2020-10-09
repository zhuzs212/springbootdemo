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
     * @param username
     * @return
     */
    UserDO getUser(String username);

    /**
     * @param username
     * @return
     */
    PermissionDO getPermission(String username);
}
