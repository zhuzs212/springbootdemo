package com.zhuzs.admin.mapper;

import com.zhuzs.admin.entity.domain.UserDO;
import com.zhuzs.admin.entity.request.QueryUserRequest;
import com.zhuzs.admin.entity.request.SaveUserRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description：
 * @author: zhu_zishuang
 * @date: 2020-04-26 08:29
 */
public interface UserMapper {

    /**
     * 新增用户
     *
     * @param userDto
     * @return
     */
    int saveUser(@Param("userDto") SaveUserRequest userDto);

    /**
     * 查询用户列表
     *
     * @param queryUserRequest
     * @return 用户列表
     */
    List<UserDO> listUser(@Param("queryUserRequest") QueryUserRequest queryUserRequest);
}

