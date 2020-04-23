package com.zhuzs.admin.controller;

import com.zhuzs.admin.service.UserService;
import com.zhuzs.entity.admin.User;
import com.zhuzs.admin.support.BaseController;
import com.zhuzs.admin.support.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description：用户控制器
 * @author: zhu_zishuang
 * @date: 2020-04-22 15:07
 */
@RestController
@RequestMapping(value = "user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @PostMapping("/findUser")
    public Result<User> findUser() {
        return ok(userService.findUser());
    }
}

