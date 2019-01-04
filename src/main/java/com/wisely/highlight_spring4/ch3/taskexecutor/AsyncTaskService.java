package com.wisely.highlight_spring4.ch3.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 通过@Async注解表明该方法是个异步方法，如果注解在类级别上，则表明该类所有的方法都是异步方法
 * 这里的方法会自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor
 */
@Service
public class AsyncTaskService {
    @Async
    public void executeAsyncTask(Integer i) {
        System.out.println("执行异步任务：" + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        System.out.println("执行异步任务+1：" + (i+1));
    }
}
