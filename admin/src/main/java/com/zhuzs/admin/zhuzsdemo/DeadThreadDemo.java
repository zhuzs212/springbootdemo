package com.zhuzs.admin.zhuzsdemo;

import com.zhuzs.admin.zhuzsdemo.thread.ScheduledThreadPoolFactory;

/**
 * 死锁案例
 *
 * @author zhu_zishuang
 * @date 2021-03-04
 */
class DeadLockDemo {

    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();

        ScheduledThreadPoolFactory factory = ScheduledThreadPoolFactory.getInstance();
//        factory.createThread(new AbstractTaskThread());

        new Thread(() -> {
            String name = Thread.currentThread().getName();
            synchronized (lockA) {
                System.out.println(name + " got lockA,  want LockB");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                synchronized (lockB) {
                    System.out.println(name + " got lockB");
                    System.out.println(name + ": say Hello!");
                }
            }
        }, "线程-A").start();

        new Thread(() -> {

            String name = Thread.currentThread().getName();
            synchronized (lockB) {
                System.out.println(name + " got lockB, want LockA");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                synchronized (lockA) {
                    System.out.println(name + " got lockA");
                    System.out.println(name + ": say Hello!");
                }
            }

        }, "线程-B").start();

    }

}