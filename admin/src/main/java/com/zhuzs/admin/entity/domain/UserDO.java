package com.zhuzs.admin.entity.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 用户 映射实体
 *
 * @author zhu_zishuang
 * @date 2020-09-17
 */
@Data
@Component
@Accessors
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

    /**
     * 组织编号
     */
    @Value("${user.orgNo}")
    private String orgNo;
}

