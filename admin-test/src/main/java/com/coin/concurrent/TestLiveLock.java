package com.coin.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName TestLiveLock
 * @Description: 活锁，解决办法，时间错开
 * @Author kh
 * @Date 2021/3/20 11:44
 * @Version V1.0
 **/
@Slf4j(topic = "TestLiveLock")
public class TestLiveLock {
    static volatile int count = 10;

    public static void main(String[] args) {
        new Thread(() -> {
            while (count > 0) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                log.info("count: {}", count);
            }
        }, "a").start();

        new Thread(() -> {
            while (count < 20) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                log.info("count: {}", count);
            }
        }, "b").start();
    }
}
