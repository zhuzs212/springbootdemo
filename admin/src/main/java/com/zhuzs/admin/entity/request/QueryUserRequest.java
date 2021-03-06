package com.zhuzs.admin.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * 查询用户 请求参数
 *
 * @author zhu_zishuang
 * @date 2020-09-16
 */
@Data
@ToString
@ApiModel(value = "查询用户请求入参实体")
public class QueryUserRequest {
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @NotEmpty(message = "用户姓名不能为空！")
    private String name;
    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;

    private String token;
}

