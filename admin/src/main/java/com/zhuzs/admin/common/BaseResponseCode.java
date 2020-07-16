package com.zhuzs.admin.common;

import lombok.experimental.Accessors;

/**
 * @description：结果类型
 *
 * @author: zhu_zishuang
 * @date: 2020-04-22 14:29
 */
@Accessors(chain = true)
public enum BaseResponseCode implements ExceptionInfo {
    /* ============================ 通用错误码 ========================== **/
    /**
     * 禁止访问 303
     **/
    PARAMS_NOT(303, "缺少参数"),

    /**
     * 存在错误参数 304
     */
    PARAMS_NOT_RIGHT(304, "存在错误参数"),

    /**
     * 存在错误测试数据 305
     */
    DATA_ERROR(305, "存在错误测试数据"),

    /**
     * 存在错误测试数据 305
     */
    SERVER_ERROR(306, "服务异常"),

    /**
     * 错误请求 400
     **/
    BAD_REQUEST(400, "错误请求"),

    /**
     * 未经授权 401
     **/
    UNAUTHORIZED(401, "未经授权"),

    /**
     * 禁止访问 403
     **/
    FORBIDDEN(403, "禁止访问"),
    /**
     * 连接超时
     **/
    TIME_OUT(408, "连接超时"),
    /**
     * Feign连接错误
     **/
    FEIGN_CONNECT_ERROR(409, "feignClient 连接错误：%s"),
    /**
     * 操作异常 500
     **/
    INTERNAL_SERVER_ERROR(500, "操作异常"),
    /**
     * SQL异常
     **/
    SQL_ERROR_EXCEPTION(501, "SQL执行异常!"),
    /**
     * 操作失败
     **/
    OPERATION_FAILURE(507, "操作失败"),
    /**
     * 日期格式处理异常
     **/
    DATE_FORMAT_EXCEPTION(508, "日期格式处理异常"),
    /* ===========================请求成功返回====================================== */
    /**
     * 新增操作成功
     */
    SAVE_SUCCESS(201,"新增成功！"),
    /**
     * 修改操作成功
     */
    UPDATE_SUCCESS(202,"修改成功！"),
    /**
     * 删除操作成功
     */
    DELETE_SUCCESS(203,"删除成功！"),
    /* ===========================User====================================== */
    ACCOUNT_NOT(10004, "账号异常!"),
    USER_NOT_EXIT_EXCEPTION(601,"用户不存在异常");

    public final int code;
    public String message;

    BaseResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

