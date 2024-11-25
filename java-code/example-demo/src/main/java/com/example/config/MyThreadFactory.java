package com.example.config;

import lombok.AllArgsConstructor;

import java.util.concurrent.ThreadFactory;

/**
 * @auther wendongchao
 * @date 2024/11/25 20:22
 **/
@AllArgsConstructor
public class MyThreadFactory implements ThreadFactory {
    private ThreadFactory factory;
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = factory.newThread(r);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        return thread;
    }
}
