package com.example.config;


import lombok.extern.slf4j.Slf4j;

/**
 * @auther wendongchao
 * @date 2024/11/25 18:17
 **/
@Slf4j
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        log.info("线程{}发生异常，异常信息：{}", t.getName(), e.getMessage());
    }
}
