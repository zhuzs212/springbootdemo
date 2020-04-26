package com.zhuzs.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuzs.entity.admin.User;
import com.zhuzs.entity.admin.dto.UserDto;
import com.zhuzs.entity.admin.vo.UserVo;
import org.apache.ibatis.annotations.Param;

/**
 * @description：
 * @author: zhu_zishuang
 * @date: 2020-04-26 08:29
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     *  新增用户
     * @param userDto
     * @return
     */
    int saveUser(@Param("userDto") UserDto userDto);

    /**
     * 获取用户列表
     * @param userDto
     * @param page
     * @return
     */
    Page<UserVo> listUser(@Param("page") Page<UserVo> page, @Param("userDto") UserDto userDto);
}

