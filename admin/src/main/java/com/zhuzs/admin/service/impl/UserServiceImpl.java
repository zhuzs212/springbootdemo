package com.zhuzs.admin.service.impl;

import com.zhuzs.admin.entity.domain.PermissionDO;
import com.zhuzs.admin.entity.domain.UserDO;
import com.zhuzs.admin.mapper.UserMapper;
import com.zhuzs.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 用户接口 实现
 *
 * @author zhu_zishuang
 * @date 2020-09-17
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 注入 User 持久层
     */
    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(cacheNames = "user", key = "#name", unless = "#result == null")
    public UserDO getUser(String name) {
        return userMapper.getUser(name);
    }

    @Override
    public PermissionDO getPermission(String name) {
        return userMapper.getPermission(name);
    }
}

