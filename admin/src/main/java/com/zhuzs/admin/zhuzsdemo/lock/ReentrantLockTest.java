package com.zhuzs.admin.zhuzsdemo.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock demo
 *
 * @author zhu_zishuang
 * @date 2021-02-24
 */
public class ReentrantLockTest {
    public static void main(String[] args) throws InterruptedException {

        // 可重入性
        reentrant();
    }

    /**
     * 可重入性
     *
     * @author zhu_zishuang
     * @date 2021-02-24
     */
    public static void reentrant() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            long num = number(24);
            System.out.println("24个月后，兔子的总数量为：" + num);
        } finally {
            lock.unlock();
        }
    }


    /**
     * 有一对兔子，生长三个月后。开始生第一对兔子，并且以后每月生一对兔子，小兔子生长三个月后，也开始生兔子，问N个月后兔子的总数量
     *
     * @param mouth
     * @return N个月后兔子的总数量
     */
    public static long number(int mouth) {
        if (mouth < 0) {
            System.out.println("您输入的数字有误");
        }
        //刚开始和第一、第二个月只有一对兔子
        if (mouth == 1 || mouth == 2 || mouth == 0) {
            return 1;
        } else {
            //前一月兔子数+通过生长三个月后，可以生育的兔[poj
            return number(mouth - 1) + number(mouth - 3);
        }

    }
}