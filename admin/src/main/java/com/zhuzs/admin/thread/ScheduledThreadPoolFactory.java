package com.zhuzs.admin.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.zhuzs.admin.exception.ServiceException;
import com.zhuzs.admin.exception.SysExceptionEnum;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 周期性任务线程池
 *
 * @author: zhu_zishuang
 * @date: 2020-11-26
 */
public class ScheduledThreadPoolFactory {
    /**
     * 核心线程数
     */
    public static final Integer CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors() + 1;

    /**
     * 最大线程数
     */
    public static final Integer MAX_POOL_SIZE = 20;

    /**
     * 核心线程外的线程最大空闲时间
     */
    public static final Long KEEP_ALIVE_TIME = 60L;

    /**
     * 周期性/延时性任务线程池
     */
    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    /**
     * 可缓存线程池
     */
    private final ThreadPoolExecutor threadPoolExecutor;

    /**
     * 构造方法
     */
    private ScheduledThreadPoolFactory() {
        scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(
                CORE_POOL_SIZE,
                new ThreadFactoryBuilder().setNameFormat("scheduled-threadPool-%d").build()
        );
        threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                CORE_POOL_SIZE * 2,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(MAX_POOL_SIZE),
                new ThreadFactoryBuilder().setNameFormat("scheduled-threadPool-%d").build(),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

    /**
     * 枚举单例
     */
    private enum Singleton {
        /**
         * 枚举实例
         */
        INSTANCE;

        private final ScheduledThreadPoolFactory instance;

        Singleton() {
            instance = new ScheduledThreadPoolFactory();
        }
    }

    /**
     * 获取线程池工厂单例
     *
     * @return 线程池工厂对象
     */
    public static ScheduledThreadPoolFactory getInstance() {
        return Singleton.INSTANCE.instance;
    }

    public void createThread(AbstractTaskThread abstractTaskThread) {
        switch (abstractTaskThread.threadTypeEnum) {
            // 不带延时的周期性线程类型
            case TASK_SCHEDULE_AT_FIXED_RATE:
                scheduledThreadPoolExecutor.scheduleAtFixedRate(
                        abstractTaskThread,
                        abstractTaskThread.getInitialDelay(),
                        abstractTaskThread.getPeriod(),
                        TimeUnit.MILLISECONDS
                );
                break;
            // 带延时的周期性线程类型
            case TASK_SCHEDULE_WITH_FIXED_DELAY:
                scheduledThreadPoolExecutor.scheduleWithFixedDelay(
                        abstractTaskThread,
                        abstractTaskThread.getInitialDelay(),
                        abstractTaskThread.getPeriod(),
                        TimeUnit.MILLISECONDS
                );
                break;
            // 延时的任务线程类型
            case TASK_SCHEDULE_DELAY:
                scheduledThreadPoolExecutor.schedule(
                        abstractTaskThread,
                        abstractTaskThread.getInitialDelay(),
                        TimeUnit.MILLISECONDS
                );
                break;
            // 缓存线程类型
            case TASK_CACHED:
                threadPoolExecutor.execute(abstractTaskThread);
                break;
            default:
                throw new ServiceException(SysExceptionEnum.CREATE_THREAD_EXCEPTION);
        }

    }

}

