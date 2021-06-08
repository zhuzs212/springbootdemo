package com.zhuzs.admin.zhuzsdemo.aop.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * jdk proxy test
 *
 * @author zhu_zishuang
 * @date 6/7/21
 */
public class JdkproxyTest {
    public static void main(String[] args) {
        Class[] clss = {UserService.class};
        UserService userService = (UserService) Proxy.newProxyInstance(JdkproxyTest.class.getClassLoader(), clss, new JdkProxy(new UserServiceImpl()));
        userService.add(1, 3);
        userService.result("这是第二个方法...");
    }
}

/**
 * proxy
 *
 * @author zhu_zishuang
 * @date 6/7/21
 */
class JdkProxy implements InvocationHandler {

    /**
     * 被代理类
     */
    private Object obj;

    public JdkProxy(Object obj) {
        this.obj = obj;
    }

    /**
     * 增强逻辑
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //
        System.out.println(" 方法前执行，methodName： " + method.getName() + "，参数：" + Arrays.toString(args));

        Object res = method.invoke(obj, args);

        //
        System.out.println(" 方法后执行，方法输出： " + res);
        return res;
    }
}

