package com.zhuzs.admin.service.impl;

import com.zhuzs.admin.service.UserService;
import com.zhuzs.entity.admin.User;
import com.zhuzs.exception.ResultCode;
import com.zhuzs.exception.ServiceException;
import org.springframework.stereotype.Service;

/**
 * @description：user service实现
 * @author: zhu_zishuang
 * @date: 2020-04-22 15:29
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() throws RuntimeException{
        User user = new User("zhuzs", 29);
        if (true) {
            throw new ServiceException(ResultCode.USER_NOT_EXIT_EXCEPTION);
        }
        return user;
    }
}

