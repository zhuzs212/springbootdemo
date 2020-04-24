package com.zhuzs.entity.admin.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuzs.entity.admin.User;
import com.zhuzs.entity.admin.validated.Insert;
import com.zhuzs.entity.admin.validated.Update;
import com.zhuzs.entity.admin.vo.UserVo;
import lombok.Data;
import lombok.ToString;
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
@ToString
public class UserDto extends User {
    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空！", groups = {Update.class})
    protected String name;

    /**
     * 年龄
     */
    protected Integer age;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式错误！", groups = {Insert.class})
    protected String email;

    /**
     * 分页数据
     */
    Page<UserVo> page = new Page<>();
}

