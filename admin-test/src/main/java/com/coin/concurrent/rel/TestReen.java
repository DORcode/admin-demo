package com.coin.concurrent.rel;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestReen
 * @Description: 可重入特性
 * @Author kh
 * @Date 2021/3/20 19:58
 * @Version V1.0
 **/
@Slf4j
public class TestReen {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        lock.lock();
        try {
            m1();
        } finally {
            lock.unlock();
        }
    }

    private static void m1() {
        lock.lock();
        try {
            log.info("m1运行");
            m2();
        } finally {
            lock.unlock();
        }
    }

    private static void m2() {
        lock.lock();
        try {
            log.info("m2运行");
        } finally {
            lock.unlock();
        }
    }
}
