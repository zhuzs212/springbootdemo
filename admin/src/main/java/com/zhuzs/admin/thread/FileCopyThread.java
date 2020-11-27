package com.zhuzs.admin.thread;

import com.zhuzs.admin.comm.ThreadTypeEnum;
import com.zhuzs.admin.zhuzsdemo.task.TaskDemoService;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * 文件拷贝线程
 *
 * @author: zhu_zishuang
 * @date: 2020-11-26
 */
@Slf4j
public class FileCopyThread extends AbstractTaskThread {
    // TODO 测试用途
    private TaskDemoService taskDemoService;

    /**
     * 文件拷贝线程构造方法
     */
    public FileCopyThread(TaskDemoService taskDemoService) {
        this.taskDemoService = taskDemoService;
        taskThreadId = UUID.randomUUID().toString();
        // 带延时的周期性线程类型
        threadTypeEnum = ThreadTypeEnum.TASK_SCHEDULE_WITH_FIXED_DELAY;
        initialDelay = 2 * 1000L;
        period = 5 * 1000L;
    }

    @Override
    public void run() {
        log.info("文件拷贝任务，开始执行！");
        taskDemoService.dailyWriting();
        log.info("文件拷贝任务，执行结束！");
    }
}

