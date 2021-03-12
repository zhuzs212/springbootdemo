package com.zhuzs.admin.exception;

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
     * 无权访问
     */
    PERMISSION_NOT(10003, "无访问权限"),

    /**
     * 数据校验异常
     */
    PPARAMETER_EMPTY_EXCEPTION(10000, null),
    /**
     * 系统发生异常
     */
    SYS_EXCEPTION(10001, "系统发生异常！"),
    /**
     * 创建线程失败异常
     */
    CREATE_THREAD_EXCEPTION(10002, "创建线程失败！"),
    /**
     * 创建线程失败异常
     */
    INCREMENT_LESS_THAN_ZERO(10003, "递增因子小于0！"),
    /**
     * 文件导出关闭流异常
     */
    EXPORT_EXCEPTION(10004, "文件导出关闭流异常！"),
    /**
     * 用户名不存在
     */
    ACCOUNT_IS_EMPTY(10005, "用户名不能为空！"),

    /**
     * 用户名不存在
     */
    ACCOUNT_NOT_EXIST(10006, "用户不存在！"),
    /**
     * 密码错误
     */
    PASSWORD_ERROR(10007, "密码错误！");

    @Getter
    private final int code;

    @Getter
    private final String message;
}
