package com.zhuzs.admin.service.impl;

import com.github.pagehelper.PageSerializable;
import com.github.pagehelper.page.PageMethod;
import com.zhuzs.admin.common.OperationEnum;
import com.zhuzs.admin.common.PageRequest;
import com.zhuzs.admin.entity.domain.UserDO;
import com.zhuzs.admin.entity.request.QueryUserRequest;
import com.zhuzs.admin.entity.request.SaveUserRequest;
import com.zhuzs.admin.exception.ServiceException;
import com.zhuzs.admin.mapper.UserMapper;
import com.zhuzs.admin.service.UserService;
import com.zhuzs.admin.service.constant.ExceptionConstantEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
    @CacheEvict(cacheNames = "product", key = "123")
    public OperationEnum saveUser(SaveUserRequest userDto) {
        userMapper.saveUser(userDto);
        return OperationEnum.SAVE_SUCCESS;
    }

    @Override
    public UserDO getUser() {
        if (true) {
            throw new ServiceException(ExceptionConstantEnum.USER_NOT_EXIT_EXCEPTION);
        }
        return null;
    }

    @Override
//    @Cacheable(cacheNames = "product", key = "123")
    public PageSerializable<UserDO> listUser(PageRequest<QueryUserRequest> pageRequest) {
        PageMethod.offsetPage(pageRequest.getCurrent(),pageRequest.getSize());
        return new PageSerializable(userMapper.listUser(pageRequest.getData()));
    }
}

