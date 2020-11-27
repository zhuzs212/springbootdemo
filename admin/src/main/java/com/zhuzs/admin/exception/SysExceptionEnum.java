package com.zhuzs.admin.exception;

import com.zhuzs.admin.comm.ExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统异常 枚举
 *
 * @author: zhu_zishuang
 * @date: 2020-09-17
 */
@AllArgsConstructor
public enum SysExceptionEnum implements ExceptionInterface {
    /**
     * 系统发生异常
     */
    SYS_EXCEPTION(10001, "系统发生异常！"),
    /**
     * 创建线程失败异常
     */
    CREATE_THREAD_EXCEPTION(10002, "创建线程失败！");

    @Getter
    private final int code;

    @Getter
    private final String message;
}
