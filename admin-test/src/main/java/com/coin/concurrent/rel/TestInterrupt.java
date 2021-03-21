package com.coin.concurrent.rel;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestInterrupt
 * @Description: 可打断锁
 * @Author kh
 * @Date 2021/3/20 20:03
 * @Version V1.0
 **/
@Slf4j(topic = "TestInterrupt")
public class TestInterrupt {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            try {
                log.info("尝试获取到锁");
                lock.lockInterruptibly();
                Thread.sleep(2000);
            } catch (Exception e) {
                log.info("没有获取到锁");
            }
            try {

            } finally {
                lock.unlock();
            }
        }, "a");

        lock.lock();
        a.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a.interrupt();
    }
}
