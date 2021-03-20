package com.coin.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName TestDeadLock
 * @Description: TODO
 * @Author kh
 * @Date 2021/3/7 10:01
 * @Version V1.0
 **/
@Slf4j(topic = "TestDeadLock")
public class TestDeadLock {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();

        new Thread(() -> {
            synchronized (a) {
                log.info("a锁");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    log.info("a线程b");
                }
            }
        }, "a").start();

        new Thread(() -> {
            synchronized (b) {
                log.info("b锁");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    log.info("b线程a");
                }
            }
        }, "b").start();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


