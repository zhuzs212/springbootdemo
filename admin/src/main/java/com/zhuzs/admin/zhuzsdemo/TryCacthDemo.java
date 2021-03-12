package com.zhuzs.admin.zhuzsdemo;

/**
 * finally是在try的return语句之后执行
 *
 * @author zhu_zishuang
 * @date 2021-03-02
 */
public class TryCacthDemo {
    public static void main(String[] args) {
//        System.out.println(" test1: " + new TryCacthDemo().test1());
//        System.out.println(" test2: " + new TryCacthDemo().test2());
        new TryCacthDemo().test3(null);
        new TryCacthDemo().test3(null);
    }

    public int test1() {
        int num = 1;
        try {
            return num;
        } finally {
            ++num;
        }
    }

    public int test2() {
        int num = 1;
        try {
            return num;
        } finally {
            return ++num;
        }
    }
    public void test3(Object obj) {
        System.out.println(" null is Object ! ");
    }

    public void test3(String str) {
        System.out.println(" null is String ! ");
    }
}

