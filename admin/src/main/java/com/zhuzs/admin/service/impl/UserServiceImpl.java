package com.zhuzs.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuzs.admin.common.BaseResponseCode;
import com.zhuzs.admin.entity.CodeValue;
import com.zhuzs.admin.entity.dto.UserDto;
import com.zhuzs.admin.entity.vo.UserVo;
import com.zhuzs.admin.exception.ServiceException;
import com.zhuzs.admin.mapper.UserMapper;
import com.zhuzs.admin.service.UserService;
import com.zhuzs.common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @description：user service实现
 * @author: zhu_zishuang
 * @date: 2020-04-22 15:29
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 注入 User 持久层
     */
    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseResponseCode saveUser(UserDto userDto) {
        return userMapper.saveUser(userDto) == Constant.ONE ? BaseResponseCode.SAVE_SUCCESS : BaseResponseCode.OPERATION_FAILURE;
    }

    @Override
    public UserVo getUser() {
        if (true) {
            throw new ServiceException(BaseResponseCode.USER_NOT_EXIT_EXCEPTION);
        }
        return null;
    }

    @Override
    public Page<UserVo> listUser(UserDto userDto) {
        Page<UserVo> page = userDto.getPage();
        return userMapper.listUser(page, userDto);
    }

    @Override
    public List<CodeValue> config(UserDto userDto) {

        List<CodeValue> list = new ArrayList<>();

        // 数据解析
        String jsonData = userDto.getJsonData();
        jsonData = jsonData.substring(2,jsonData.length()-2);

        String[] data = jsonData.split(",");
        for(String str:data){
            String[] keyValues = str.split(":");
            CodeValue codeValue = new CodeValue();
            codeValue.setSysCode(keyValues[0].split("'")[1]);
            codeValue.setDefaultValue(keyValues[1].split("'")[1]);
            list.add(codeValue);

        }
        return list;
    }
}

