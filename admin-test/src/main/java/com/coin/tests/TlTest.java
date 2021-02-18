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
        Semaphore semaphore = new Semaphore(1);

        for (int i = 0; i < T; i++) {

            new Thread(() -> {
                try {
                    semaphore.acquire();
                    int b = B_TL.get() - RANDOM.nextInt(B);
                    int k = K_TL.get() + RANDOM.nextInt(T / 2);
                    int l = L_TL.get() - RANDOM.nextInt(L);

                    System.out.println("b = " + b);
                    System.out.println("k = " + k);
                    System.out.println("l = " + l);

                    B_TL.remove();
                    K_TL.remove();
                    L_TL.remove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("B_TL = " + B_TL.get());
        System.out.println("K_TL = " + K_TL.get());
        System.out.println("L_TL.get() = " + L_TL.get());
    }
}
