package com.zhuzs.admin.exception;

import com.zhuzs.admin.support.BaseResponseCode;

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

    public ServiceException(String message, BaseResponseCode resultCode) {
        super(message);
        this.code = resultCode.code;
        this.message = message;
    }

    public ServiceException(BaseResponseCode resultCode) {
        this(resultCode.message, resultCode);
    }

    public ServiceException(String message, BaseResponseCode resultCode, Object data) {
        this(message, resultCode);
        this.data = data;
    }

    public ServiceException(BaseResponseCode resultCode, Object data) {
        this(resultCode.message, resultCode, data);
    }
}

