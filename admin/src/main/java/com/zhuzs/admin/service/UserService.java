package com.zhuzs.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuzs.admin.entity.dto.UserDto;
import com.zhuzs.admin.entity.vo.UserVo;

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
    Enum saveUser(UserDto userDto);

    UserVo getUser();

    Page<UserVo> listUser(UserDto userDto);
}
