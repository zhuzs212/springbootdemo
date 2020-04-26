package com.zhuzs.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuzs.admin.mapper.UserMapper;
import com.zhuzs.admin.service.UserService;
import com.zhuzs.common.Constant;
import com.zhuzs.entity.admin.User;
import com.zhuzs.admin.exception.ResultCode;
import com.zhuzs.admin.exception.ServiceException;
import com.zhuzs.entity.admin.dto.UserDto;
import com.zhuzs.entity.admin.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description：user service实现
 * @author: zhu_zishuang
 * @date: 2020-04-22 15:29
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     *
     */
    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean saveUser(UserDto userDto) {
        return userMapper.saveUser(userDto) == Constant.Number.ONE.intValue();
    }

    @Override
    public UserVo getUser() throws ServiceException{
//        UserVo userVo = new UserVo("zhuzs", 29,"");
        if(true){
            throw new ServiceException(ResultCode.USER_NOT_EXIT_EXCEPTION);
        }
        return null;
    }

    @Override
    public Page<UserVo> listUser(UserDto userDto) {
        Page<UserVo> page = userDto.getPage();
        return userMapper.listUser(page, userDto);
    }
}

