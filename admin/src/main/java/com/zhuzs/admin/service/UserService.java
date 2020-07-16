package com.zhuzs.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuzs.admin.common.BaseResponseCode;
import com.zhuzs.admin.entity.dto.UserDto;
import com.zhuzs.admin.entity.vo.UserVo;
import com.zhuzs.admin.entity.CodeValue;

import java.util.List;

/**
 * @description：user service接口
 * @author: zhu_zishuang
 * @date: 2020-04-22 15:27
 */
public interface UserService {
    /**
     * 新增用户
     * @param userDto
     * @return
     */
    BaseResponseCode saveUser(UserDto userDto);

    /**
     * 查询单个用户
     * @return
     */
    UserVo getUser();

    /**
     * 查询用户列表 分页
     * @param userDto
     * @return
     */
    Page<UserVo> listUser(UserDto userDto);

    /**
     * 用户基本配置
     * @param userDto
     * @return
     */
    List<CodeValue> config(UserDto userDto);
}
