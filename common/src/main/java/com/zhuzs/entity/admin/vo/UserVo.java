package com.zhuzs.entity.admin.vo;

import com.zhuzs.entity.admin.User;
import lombok.Data;
import lombok.ToString;

/**
 * @title：User
 * @project_name: springbootdemo
 * @description：用户
 * @author: zhu_zishuang
 * @date: 2020-04-21 10:33
 */
@Data
@ToString(callSuper = true)
public class UserVo extends User {
    public UserVo(String name,Integer age,String email){
        super(name,age,email);
    }
}

