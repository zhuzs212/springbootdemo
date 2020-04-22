package com.zhuzs.common.entity.admin;

import lombok.AllArgsConstructor;
import lombok.Data;

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
    private String name;
    private Integer age;
}

