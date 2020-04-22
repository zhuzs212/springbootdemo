package com.zhuzs.admin.controller;

import com.zhuzs.admin.service.UserService;
import com.zhuzs.entity.admin.User;
import com.zhuzs.support.BaseController;
import com.zhuzs.support.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description：用户控制器
 *
 * @author: zhu_zishuang
 * @date: 2020-04-22 15:07
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @GetMapping("/123")
    public Result<User> getUser() {
        return ok(userService.getUser());
    }

}

