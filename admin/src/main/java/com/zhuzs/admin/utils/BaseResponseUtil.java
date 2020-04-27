package com.zhuzs.admin.utils;

import com.zhuzs.admin.support.BaseResponse;

/**
 * @description：TODO 响应包装工具类 暂未用到
 * @author: zhu_zishuang
 * @date: 2020-04-25 11:09
 */
public class BaseResponseUtil {

    /**
     * 成功编码
     */
    private static final Integer SUCCESS_CODE = 200;
    /**
     * 失败编码
     */
    private static final Integer FAIL_CODE = 500;
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
     * 包裹响应对象，此方法适合系统发生异常（校验框架异常、自定义业务异常、系统异常）场景下调用
     *
     * @param message 异常消息
     * @return 响应实体
     */
    public static BaseResponse fail(String message) {
        return new BaseResponse().setCode(FAIL_CODE).setMessage(message);
    }
}

