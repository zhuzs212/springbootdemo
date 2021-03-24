package com.zhuzs.admin.constant;

import com.zhuzs.admin.comm.ExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统异常 枚举
 *
 * @author zhu_zishuang
 * @date 2021-03-12
 */
@AllArgsConstructor
public enum SysExceptionEnum implements ExceptionInterface {
    /* ===========================User====================================== */
    /**
     * 数据校验异常
     */
    PPARAMETER_EMPTY_EXCEPTION(10000, null),

    /**
     * 用户名不存在
     */
    ACCOUNT_IS_EMPTY(10001, "用户名不能为空!"),

    /**
     * 用户名不存在
     */
    ACCOUNT_NOT_EXIST(10002, "用户不存在!"),

    /**
     * 密码错误
     */
    PASSWORD_ERROR(10003, "密码错误!"),

    /**
     * token为空，鉴权失败
     */
    TOKEN_IS_EMPTY(10004, "token 为空，鉴权失败!"),

    /**
     * token已失效
     */
    TOKEN_EXPIRED_EXCEPTION(10005, "token 已失效!"),

    /**
     * token 验证异常
     */
    JWT_VERIFICATION_EXCEPTION(10006, "token 验证异常!"),

    /**
     * 无权访问
     */
    PERMISSION_NOT(10007, "无访问权限"),

    /**
     * 系统发生异常
     */
    SYS_EXCEPTION(10008, "系统发生异常!"),

    /**
     * 创建线程失败异常
     */
    CREATE_THREAD_EXCEPTION(10009, "创建线程失败!"),

    /**
     * 创建线程失败异常
     */
    INCREMENT_LESS_THAN_ZERO(10010, "递增因子小于0!"),

    /**
     * 文件导出关闭流异常
     */
    EXPORT_EXCEPTION(10011, "文件导出关闭流异常!");

    @Getter
    private final int code;

    @Getter
    private final String message;
}
