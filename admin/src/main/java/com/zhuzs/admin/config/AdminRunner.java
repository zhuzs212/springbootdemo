package com.zhuzs.admin.config;

import com.zhuzs.admin.zhuzsdemo.task.TaskDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 项目启动初始化
 *
 * @author zhu_zishuang
 * @date 2021-03-12
 */
@Component
@Slf4j
public class AdminRunner implements CommandLineRunner {
    /**
     * 注入 TaskDemoService
     * TODO 测试用途
     */
    @Autowired
    private TaskDemoService taskDemoService;

    /**
     * 项目启动初始化方法
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
//        // 创建线程池对象
//        log.info("------创建线程池对象-------");
//        ScheduledThreadPoolFactory scheduledThreadPoolFactory = ScheduledThreadPoolFactory.getInstance();
//        // 文件拷贝线程
//        log.info("------创建文件拷贝线程-------");
//        FileCopyThread fileWriteThread = new FileCopyThread(taskDemoService);
//        scheduledThreadPoolFactory.createThread(fileWriteThread);
    }
}

