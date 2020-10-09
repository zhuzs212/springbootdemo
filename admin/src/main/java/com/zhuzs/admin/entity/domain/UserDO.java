package com.zhuzs.admin.entity.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户 映射实体
 *
 * @Author zhu_zishuang
 * @Date 2020-09-17
 */
@Data
public class UserDO {
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色
     */
    private RoleDO roleDO;
}

