package com.zhuzs.admin.entity.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
  * 用户 映射实体
  *
  * @Author zhu_zishuang
  * @Date 2020-09-17
  */
@Data
@ToString(callSuper = true)
public class UserDO {

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;
}

