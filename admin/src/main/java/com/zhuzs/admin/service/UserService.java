package com.zhuzs.admin.service;

import com.github.pagehelper.PageSerializable;
import com.zhuzs.admin.common.OperationEnum;
import com.zhuzs.admin.common.PageRequest;
import com.zhuzs.admin.entity.domain.UserDO;
import com.zhuzs.admin.entity.request.QueryUserRequest;
import com.zhuzs.admin.entity.request.SaveUserRequest;
import org.apache.ibatis.annotations.Param;

/**
  * 用户接口
  *
  * @Author zhu_zishuang
  * @Date 2020-09-17
  */
public interface UserService {
    /**
     * 新增用户
     * @param userDto 新增请求参数
     * @return
     */
    OperationEnum saveUser(SaveUserRequest userDto);

    /**
     * 查询单个用户
     * @return
     */
    UserDO getUser();

    /**
     * 分页查询 用户列表
     * @param pageRequest 分页请求参数
     * @return 用户列表
     */
    PageSerializable<UserDO> listUser(@Param("pageRequest") PageRequest<QueryUserRequest> pageRequest);

}
