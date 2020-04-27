package com.zhuzs.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuzs.admin.service.UserService;
import com.zhuzs.admin.entity.dto.UserDto;
import com.zhuzs.admin.support.validated.Insert;
import com.zhuzs.admin.support.validated.Update;
import com.zhuzs.admin.entity.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description：用户控制器
 * @author: zhu_zishuang
 * @date: 2020-04-22 15:07
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    /**
     * 注入 userService
     */
    @Autowired
    private UserService userService;

    /**
     * 新增用户
     *
     * @param userDto
     * @return
     */
    @PostMapping("/saveUser")
    public Enum saveUser(@Validated({Insert.class, Update.class}) @RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    /**
     * 查询单个用户
     *
     * @return
     */
    @PostMapping("/queryUser")
    public UserVo queryUser() {
        return userService.getUser();
    }

    /**
     * 获取用户列表
     *
     * @param userDto
     * @return
     */
    @PostMapping("/queryUsers")
    public Page<UserVo> queryUsers( @RequestBody UserDto userDto) {
        return userService.listUser(userDto);
    }
}

