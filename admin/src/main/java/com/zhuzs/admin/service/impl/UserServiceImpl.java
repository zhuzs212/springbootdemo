package com.zhuzs.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuzs.admin.service.UserService;
import com.zhuzs.entity.admin.User;
import com.zhuzs.admin.exception.ResultCode;
import com.zhuzs.admin.exception.ServiceException;
import com.zhuzs.entity.admin.dto.UserDto;
import com.zhuzs.entity.admin.vo.UserVo;
import org.springframework.stereotype.Service;

/**
 * @description：user service实现
 * @author: zhu_zishuang
 * @date: 2020-04-22 15:29
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserVo getUser() throws ServiceException{
        UserVo userVo = new UserVo("zhuzs", 29,"");
        if(userVo == null){
            throw new ServiceException(ResultCode.USER_NOT_EXIT_EXCEPTION);
        }
        return userVo;
    }

    @Override
    public Boolean saveUser(UserDto userDto) {

        return null;
    }

    @Override
    public Page<UserVo> listUser(UserDto userDto) {
        return null;
    }
}

