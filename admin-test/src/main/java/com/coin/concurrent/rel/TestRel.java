package com.coin.concurrent.rel;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestRel
 * @Description: ReentrantLock，
 * 可中断
 * 可设置超时时间
 * 可设置为公平锁
 * 支持多个条件变量
 * 与synchronized一样，都支持可重入
 * @Author kh
 * @Date 2021/3/20 19:47
 * @Version V1.0
 **/
@Slf4j
public class TestRel {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            lock.lock();

            try {
                log.info("获取到了锁");
            } finally {
                lock.unlock();
            }
        }, "a").start();

        new Thread(() -> {
            lock.lock();

            try {
                log.info("获取到了锁");
            } finally {
                lock.unlock();
            }
        }, "b").start();
    }
}
