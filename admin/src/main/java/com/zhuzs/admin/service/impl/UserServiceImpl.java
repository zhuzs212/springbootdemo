package com.zhuzs.admin.service.impl;

import com.zhuzs.admin.service.UserService;
import com.zhuzs.entity.admin.User;
import com.zhuzs.admin.exception.ResultCode;
import com.zhuzs.admin.exception.ServiceException;
import org.springframework.stereotype.Service;

/**
 * @description：user service实现
 * @author: zhu_zishuang
 * @date: 2020-04-22 15:29
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findUser() throws ServiceException{
        User user = new User("zhuzs", 29);
        if (user != null) {
            throw new ServiceException(ResultCode.ACCOUNT_NOT);
        }
        return user;
    }
}

