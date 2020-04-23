package com.zhuzs.admin.support;


import com.zhuzs.admin.exception.ResultCode;

/**
 * @description：公共controller
 * @author: zhu_zishuang
 * @date: 2020-04-22 14:21
 */
public class BaseController {

    /**
     * 接口返回数据 全局统一封装
     */
    protected Result ok() {
        return new Result().ok();
    }

    protected <T> Result<T> ok(T data) {
        return new Result<T>().ok(data);
    }

    protected Result ok(ResultCode resultCode, Object data) {
        Result result = new Result(resultCode);
        result.setData(data);
        return result;
    }

}

