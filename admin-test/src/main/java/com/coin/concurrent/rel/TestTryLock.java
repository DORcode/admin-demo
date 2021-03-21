package com.coin.concurrent.rel;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestTryLock
 * @Description: TODO
 * @Author kh
 * @Date 2021/3/20 20:14
 * @Version V1.0
 **/
@Slf4j(topic = "TestTryLock")
public class TestTryLock {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            if (!lock.tryLock()) {
                log.info("没有获取到锁");
                return;
            }
            try {
                log.info("获取到了锁");
            } finally {
                lock.unlock();
            }
        });

        lock.lock();
        t1.start();
    }
}
