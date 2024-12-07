package com.common.singleton;

/**
 * @auther wendongchao
 * @date 2024/12/7 15:01
 **/
public class Singleton {
    private static volatile Singleton instance;
    private Singleton() {
    }
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
