package com.zhuzs.entity;

import lombok.Data;

/**
 * @description：分页接口统一入参
 * @author: zhu_zishuang
 * @date: 2020-04-24 08:32
 */
@Data
public class PageParam<T> {
    /**
     * 每页显示条目个数
     */
    private Integer pageSize;
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 页面请求参数对象
     */
    private T data;
}

