package com.coin.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName TestStatus
 * @Description: TODO
 * @Author kh
 * @Date 2021/3/20 10:40
 * @Version V1.0
 **/
@Slf4j(topic = "TestStatus")
public class TestStatus {


    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("a线程获得锁");
            }

        }, "a").start();

        new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("b线程获得锁");
            }

        }, "b").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock) {
            lock.notifyAll();
        }

        log.info("abc");

    }

}
