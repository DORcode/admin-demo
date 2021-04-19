package com.coin.pattern.factory.singleton;

/**
 * @ClassName LockFreeSingleton
 * @Description: 无锁线程安全单例模式
 * @Author kh
 * @Date 2021-04-19 11:21
 * @Version V1.0
 **/
public class LockFreeSingleton {
    public static final LockFreeSingleton instance = new LockFreeSingleton();

    private LockFreeSingleton() {
    }

    public static synchronized LockFreeSingleton getInstance() {
        return instance;
    }
}
