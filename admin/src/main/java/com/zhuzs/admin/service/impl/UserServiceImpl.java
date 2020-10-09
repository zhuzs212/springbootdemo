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
 * @Author zhu_zishuang
 * @Date 2020-09-17
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 注入 User 持久层
     */
    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(cacheNames = "uer", key = "#userName")
    public UserDO getUser(String userName) {
        return userMapper.getUser(userName);
    }

    @Override
    public PermissionDO getPermission(String userName) {
        return userMapper.getPermission(userName);
    }
}

