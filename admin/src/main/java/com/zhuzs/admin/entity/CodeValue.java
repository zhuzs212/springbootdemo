package com.zhuzs.admin.entity;

import lombok.Data;
import lombok.ToString;

/**
 *
 * @description：编码 code/value 实体
 * @author: zhu_zishuang
 * @date: 2020-06-10
 */
@Data
@ToString
public class CodeValue {

    /**
     * 编码
     */
    private String sysCode;

    /**
     * 值
     */
    private String defaultValue;
}

