package com.zhuzs.admin.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统异常 枚举
 *
 * @author: zhu_zishuang
 * @date: 2020-09-17
 */
@AllArgsConstructor
public enum SysExceptionEnum implements  ExceptionInterface{
    /**
     * 系统发生异常
     */
    SYS_EXCEPTION(10001,"系统发生异常！");

    @Getter
    private final int code;

    @Getter
    private final String message;
}
