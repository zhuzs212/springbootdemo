package com.zhuzs.admin.exception;

import com.zhuzs.admin.common.BaseResponseCode;
import com.zhuzs.admin.common.ExceptionInfo;

/**
 * @description：业务异常累(业务处理时手动抛出异常)
 *
 * @author: zhu_zishuang
 * @date: 2020-04-22 15:35
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 1368537676554131340L;

    public final int code;
    public final String message;
    public Object data;

    public ServiceException(String message, ExceptionInfo exceptionInfo) {
        super(message);
        this.code = exceptionInfo.getCode();
        this.message = message;
    }

    public ServiceException(ExceptionInfo exceptionInfo) {
        this(exceptionInfo.getMessage(), exceptionInfo);
    }

    /**
     *
     * @param message
     * @param resultCode
     * @param data
     */
    public ServiceException(String message, BaseResponseCode resultCode, Object data) {
        this(message, resultCode);
        this.data = data;
    }

    public ServiceException(BaseResponseCode resultCode, Object data) {
        this(resultCode.message, resultCode, data);
    }
}

