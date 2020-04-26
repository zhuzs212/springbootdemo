package com.zhuzs.entity.admin.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuzs.entity.admin.User;
import com.zhuzs.entity.admin.vo.UserVo;
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
@ToString
public class UserDto extends User {

    /**
     * 分页数据
     */
    Page<UserVo> page = new Page<>();
}

