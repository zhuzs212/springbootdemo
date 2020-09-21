package com.zhuzs.admin.controller;

import com.github.pagehelper.PageSerializable;
import com.zhuzs.admin.common.OperationEnum;
import com.zhuzs.admin.common.PageRequest;
import com.zhuzs.admin.entity.domain.UserDO;
import com.zhuzs.admin.entity.request.QueryUserRequest;
import com.zhuzs.admin.entity.request.SaveUserRequest;
import com.zhuzs.admin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
  * User 控制器
  *
  * @Author zhu_zishuang
  * @Date 2020-09-16
  */
@RestController
@RequestMapping(value = "user")
@Api(tags = "用户管理")
public class UserController {

    /**
     * 注入 userService
     */
    @Autowired
    private UserService userService;

    /**
     * 新增用户
     *
     * @param userRequest 新增请求参数
     * @return
     */
    @PostMapping("/saveUser")
    @ApiOperation("用户新增接口")
    public OperationEnum saveUser(@RequestBody SaveUserRequest userRequest) {
        return userService.saveUser(userRequest);
    }

    /**
     * 查询单个用户
     *
     * @return
     */
    @PostMapping("/queryUser")
    public UserDO queryUser() {
        return userService.getUser();
    }

    /**
     * 获取用户列表
     *
     * @param pageRequest 分页请求参数
     * @return 用户列表
     */
    @PostMapping("/queryUsers")
    @ApiOperation("获取用户列表")
    public PageSerializable<UserDO> queryUsers(@RequestBody PageRequest<QueryUserRequest> pageRequest) {
        return userService.listUser(pageRequest);
    }
}