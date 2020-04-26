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
public class Result<T> {
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

    //
//    public Result() {
//    }
//
//    public Result(ResultCode resultCode) {
//        this.code = resultCode.code;
//        this.message = resultCode.message;
//    }
//
//    public Result(ResultCode resultCode, String message, T data) {
//        this.code = resultCode.code;
//        this.message = message;
//        this.data = data;
//    }
//
//    public Result(String status, int code, String message, T data) {
//        this.status = status;
//        this.code = code;
//        this.message = message;
//        this.data = data;
//    }
//
//    public Result(String status, int code, String message) {
//        this.status = status;
//        this.code = code;
//        this.message = message;
//    }
//
//    public Result(String status, ResultCode resultCode) {
//        this.status = status;
//        this.code = resultCode.code;
//        this.message = resultCode.message;
//    }
//
//    public Result(String status, ResultCode resultCode, T data) {
//        this.status = status;
//        this.code = resultCode.code;
//        this.message = resultCode.message;
//        this.data = data;
//    }
//
    public Result<T> ok(T data) {
        this.code = SUCCESS;
        this.data = data;
        return this;
    }

    public Result ok() {
        this.code = SUCCESS;
        return this;
    }

}

