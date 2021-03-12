package com.zhuzs.admin.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * 查询用户 请求参数
 *
 * @author zhu_zishuang
 * @date 2020-09-16
 */
@Data
@ToString
@ApiModel(value = "查询用户请求入参实体")
public class LoginUserRequest {
    /**
     * 姓名
     */

    @ApiModelProperty(value = "姓名")
    private String name;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;


    /**
     * 组织编号
     */
    private String orgNo;
}

