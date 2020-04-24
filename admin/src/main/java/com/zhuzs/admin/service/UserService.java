package com.zhuzs.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuzs.entity.admin.dto.UserDto;
import com.zhuzs.entity.admin.vo.UserVo;

/**
 * @description：user service接口
 * @author: zhu_zishuang
 * @date: 2020-04-22 15:27
 */
public interface UserService {
    UserVo getUser();

    Boolean saveUser(UserDto userDto);

    Page<UserVo> listUser(UserDto userDto);
}
