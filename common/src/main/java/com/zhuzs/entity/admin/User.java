package com.zhuzs.entity.admin;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @title：User
 * @project_name: springbootdemo
 * @description：用户
 * @author: zhu_zishuang
 * @date: 2020-04-21 10:33
 */
@Data
@AllArgsConstructor
public class User {
    @NotBlank(message = "用户名不能为空！")
    protected String name;
    protected Integer age;
    @Email(message = "邮箱格式错误！")
    protected String email;


    public User() {
    }
}

