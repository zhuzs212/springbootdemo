package com.zhuzs.admin.common;

/**
 * @description：异常错误码枚举类 封装
 *
 * @author: zhu_zishuang
 * @date: 2020-07-16
 */
public interface ExceptionInfo {
    /**
     * 获取错误码
     * @return
     */
    int getCode();

    /**
     * 获取异常信息
     * @return
     */
    String getMessage();
}
