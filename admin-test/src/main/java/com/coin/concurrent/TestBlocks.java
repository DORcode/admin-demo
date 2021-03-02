package com.coin.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName TestBlocks
 * @Description: sleep不释放锁，不同对象的synchronized相同方法不互斥,
 * static和非static不互斥,不同对象的不同static sync方法互斥
 * @Author kh
 * @Date 2021/2/21 11:51
 * @Version V1.0
 **/
@Slf4j(topic = "testBlocks")
public class TestBlocks {
    public static void main(String[] args) {

        Number number = new Number();
        Number number1 = new Number();


        new Thread(() -> {
            log.info("a");
            number.a();
        }, "a").start();

        new Thread(() -> {
            log.info("b");
            number.b();
        }, "b").start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            log.info("c");
            number1.a();
        }, "c").start();

        new Thread(() -> {
            log.info("d");
            number.a();
        }, "d").start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            log.info("e");
            number.b();
        }, "e").start();

        new Thread(() -> {
            log.info("f");
            number.c();
        }, "f").start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            log.info("g");
            number.c();
        }, "g").start();

        new Thread(() -> {
            log.info("h");
            number1.d();
        }, "h").start();
    }

    static class Number {

        public synchronized void a() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info(1 + "");
        }

        public synchronized void b() {
            log.info(2 + "");
        }

        public static synchronized void c() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("3");
        }

        public static synchronized void d() {

            log.info("4");
        }
    }
}
