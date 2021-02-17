package com.coin.tests;

/**
 * @ClassName YeildTest
 * @Description: TODO
 * @Author kh
 * @Date 2021/2/16 10:47
 * @Version V1.0
 **/
public class YeildTest {
    public static void main(String[] args) {
        TestY testY = new TestY();

        new Thread(testY, "a").start();
        new Thread(testY, "b").start();
        new Thread(testY, "c").start();

    }

    static class TestY implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "开始");

            Thread.yield();
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }
}
