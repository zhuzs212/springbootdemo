package com.zhuzs.admin.zhuzsdemo.aop.jdkproxy;

/**
 * jdk proxy service demo implement
 *
 * @author zhu_zishuang
 * @date 6/7/21
 */
public class UserServiceImpl implements UserService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public String result(String info) {
        return info;
    }
}

