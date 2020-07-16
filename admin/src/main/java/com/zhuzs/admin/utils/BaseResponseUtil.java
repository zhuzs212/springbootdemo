package com.zhuzs.admin.utils;

import com.zhuzs.admin.common.BaseResponse;
import com.zhuzs.admin.common.BaseResponseCode;
import com.zhuzs.common.Constant;

/**
 * @description：响应包装工具类
 * @author: zhu_zishuang
 * @date: 2020-04-25 11:09
 */
public class BaseResponseUtil {

    /**
     * 成功编码
     */
    private static final Integer SUCCESS_CODE = 200;

    /**
     * 默认操作成功提示
     */
    private static final String DEFAULT_SUCCESS_MESSAGE = "操作成功";

    /**
     * 构造器私有，防止外部实例化
     */
    private BaseResponseUtil() {
    }

    /**
     * 包裹响应对象，此方法适合写操作没有数据实体场景下调用
     *
     * @return 响应实体
     */
    public static BaseResponse success() {
        return new BaseResponse().setCode(SUCCESS_CODE).setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    /**
     * 包裹响应对象，此方法适合查询操作有数据实体场景下调用
     *
     * @param data 数据实体
     * @return 响应实体
     */
    public static BaseResponse success(Object data) {
        return success().setData(data);
    }

    /**
     * 包裹响应对象，此方法适合 增、删、改 操作有数据实体场景下调用
     * @param baseResponseCode
     * @return
     */
    public static BaseResponse success(BaseResponseCode baseResponseCode) {
        return success().setCode(baseResponseCode.getCode()).setMessage(baseResponseCode.getMessage());
    }

    /**
     * 包裹响应对象，校验框架异常 场景下调用
     *
     * @param message 异常消息
     * @return 响应实体
     */
    public static BaseResponse fail(Integer code, String message) {
        return new BaseResponse().setStatus(Constant.ReqResult.FAIL).setCode(code).setMessage(message);
    }

    /**
     * 包裹响应对象，自定义业务异常 场景下调用
     * @param baseResponseCode
     * @return
     */
    public static BaseResponse fail(BaseResponseCode baseResponseCode) {
        return new BaseResponse().setStatus(Constant.ReqResult.FAIL).setCode(baseResponseCode.getCode()).setMessage(baseResponseCode.getMessage());
    }

    /**
     * 包裹响应对象，系统异常 场景下调用
     * @param message
     * @return 响应实体
     */
    public static BaseResponse error(String message) {
        return new BaseResponse().setStatus(Constant.ReqResult.ERROR).setCode(BaseResponseCode.INTERNAL_SERVER_ERROR.getCode()).setMessage(message);
    }
}

