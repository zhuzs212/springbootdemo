package com.zhuzs.admin.service.constant;

import com.zhuzs.admin.comm.ExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * 业务异常枚举
 *
 * @author zhu_zishuang
 * @date 2020-09-17
 */
@Accessors(chain = true)
@AllArgsConstructor
public enum ExceptionConstantEnum implements ExceptionInterface {
    /**
     * 存在错误参数 304
     */
    PARAMS_NOT_RIGHT(304, "存在错误参数"),

    /**
     * SQL异常
     **/
    SQL_ERROR_EXCEPTION(501, "SQL执行异常!");

    /**
     * 结果类型CODE
     */
    @Getter
    private final int code;

    /**
     * 结果类型描述
     */
    @Getter
    private final String message;
}

