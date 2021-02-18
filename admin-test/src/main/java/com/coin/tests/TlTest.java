package com.coin.tests;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @ClassName TlTest
 * @Description: TODO
 * @Author kh
 * @Date 2021-02-18 16:59
 * @Version V1.0
 **/
@Slf4j(topic = "tl")
public class TlTest {
    private static ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private final static Integer B = 1500;
    private final static Integer K = 0;
    private final static Integer L = 10;
    private final static Integer T = 10;


    private final static ThreadLocal<Integer> B_TL = new ThreadLocal<Integer>() {

        @Override
        protected Integer initialValue() {
            return B;
        }
    };

    private final static ThreadLocal<Integer> K_TL = new ThreadLocal<Integer>() {

        @Override
        protected Integer initialValue() {
            return K;
        }
    };

    private final static ThreadLocal<Integer> L_TL = new ThreadLocal<Integer>() {

        @Override
        protected Integer initialValue() {
            return L;
        }
    };

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < T; i++) {

            new Thread(() -> {
                try {
                    semaphore.acquire();
                    ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
                    int b = B_TL.get() - RANDOM.nextInt(B);
                    int k = K_TL.get() + RANDOM.nextInt(T / 2);
                    int l = L_TL.get() - RANDOM.nextInt(L);

                    log.debug(Thread.currentThread().getName() + "b = " + b);
                    log.debug(Thread.currentThread().getName() + "k = " + k);
                    log.debug(Thread.currentThread().getName() + "l = " + l);

                    B_TL.remove();
                    K_TL.remove();
                    L_TL.remove();
                    B_TL.set(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            }, i + "").start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.debug(Thread.currentThread().getName() + "B_TL = " + B_TL.get());
        log.debug(Thread.currentThread().getName() + "K_TL = " + K_TL.get());
        log.debug(Thread.currentThread().getName() + "L_TL = " + L_TL.get());
    }
}
