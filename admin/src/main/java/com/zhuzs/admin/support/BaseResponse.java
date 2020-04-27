package com.zhuzs.admin.support;

import com.zhuzs.common.Constant;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description：结果集
 * @author: zhu_zishuang
 * @date: 2020-04-22 14:28
 */
@Data
@Accessors(chain = true)
public class BaseResponse<T> {
    public static final int SUCCESS = 200;
    /**
     * success：成功，fail：业务返回的失败，error：非业务异常失败
     */
    private String status = Constant.ReqResult.SUCCESS;
    /**
     * 状态码
     **/
    private int code;

    /**
     * 结果数据
     **/
    private T data;

    /**
     * 结果描述
     **/
    private String message;


    public BaseResponse<T> ok(String message, BaseResponseCode resultCode) {
        this.code = resultCode.code;
        this.message = message;
        return this;
    }

    public BaseResponse<T> ok(int code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }
    public BaseResponse<T> ok(T data) {
        this.code = SUCCESS;
        this.data = data;
        return this;
    }

    public BaseResponse ok() {
        this.code = SUCCESS;
        return this;
    }

}

