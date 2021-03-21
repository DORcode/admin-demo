package com.coin.concurrent.rel;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestTryLock2
 * @Description: TODO
 * @Author kh
 * @Date 2021/3/20 20:22
 * @Version V1.0
 **/
@Slf4j(topic = "TestTryLock2")
public class TestTryLock2 {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread a = new Thread(() -> {
            try {
                if (!lock.tryLock(2, TimeUnit.SECONDS)) {
                    log.info("未获取到锁");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.info("获取锁报错");
                return;
            }

            try {
                log.info("获取到了锁");
            } finally {
                lock.unlock();
            }
        }, "a");

        lock.lock();

        log.info("获取到了锁");
        a.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.unlock();
    }
}
