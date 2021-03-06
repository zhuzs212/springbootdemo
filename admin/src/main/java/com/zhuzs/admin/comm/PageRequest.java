package com.zhuzs.admin.comm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 分页请求对象
 *
 * @author zhu_zishuang
 * @date 2021-03-12
 */
@Data
@ApiModel("分页请求对象")
public class PageRequest<T> {

    /**
     * 当前页码,默认 1
     */
    @NotNull(message = "当前页码不能为空！")
    @ApiModelProperty(value = "当前页码", required = true, example = "1")
    private int current;

    /**
     * 每页显示条数，默认 10
     */
    @NotNull(message = "每页显示条数不能为空！")
    @ApiModelProperty(value = "每页显示条数", required = true, example = "10")
    private int size;

    private T data;
}

