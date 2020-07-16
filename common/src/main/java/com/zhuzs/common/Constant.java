package com.zhuzs.common;

/**
 * @description：常量类
 * @author: zhu_zishuang
 * @date: 2020-04-22 14:22
 */
public final class Constant {
    /**
     * 构造器私有化
     */
    private Constant(){

    }

    /**
     * 返回结果 success：成功，fail：业务返回的失败，error：非业务异常失败
     */
    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";
    public static final String ERROR = "error";

    /**
     * 常用数值
     */
    public static final Integer ONE = 1;
    public static final Long MAX_PAGE_SIZE = 100_000L;


    /**
     * 常用字符
     */
    public static final String SPLIT_CLASS = " ";
    public static final String LOG_INFO_PREFIX = "登录异常，异常信息：{}";

    /**
     * 是否
     */
    public static final Byte YES = 1;
    public static final Byte NO = 0;
    public static final Integer YES_INT = 1;


}
