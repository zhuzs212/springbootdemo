package com.zhuzs.admin.entity;

import com.zhuzs.admin.common.validated.Insert;
import com.zhuzs.admin.common.validated.Update;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @title：User
 * @project_name: springbootdemo
 * @description：用户
 * @author: zhu_zishuang
 * @date: 2020-04-21 10:33
 */
@Data
public class User {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 姓名
     */
    @NotEmpty(message = "用户名不能为空！", groups = {Update.class})
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式错误！", groups = {Insert.class})
    private String email;

}

