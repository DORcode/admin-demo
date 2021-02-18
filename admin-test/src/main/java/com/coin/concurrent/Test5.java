package com.coin.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Test5
 * @Description: TODO
 * @Author kh
 * @Date 2021/2/17 21:25
 * @Version V1.0
 **/
public class Test5 {
    public static void main(String[] args) {

        Thread thread = new Thread("a") {

            @Override
            public void run() {

                for (long i = 0; i < 10000000L; i++) {

                }

                System.out.println("getState() = " + getState());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("args = " + args);
            }
        };

        Thread d = new Thread("d") {

            @Override
            public void run() {
                synchronized (Test5.class) {
                    while (true) {

                    }
                }
            }
        };

        d.start();

        Thread c = new Thread("c") {
            @Override
            public void run() {
                try {
                    d.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        c.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread f = new Thread("f") {

            @Override
            public void run() {
                synchronized (Test5.class) {

                }
            }
        };

        f.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("f = " + f.getState());
        System.out.println("c.getState() = " + c.getState());

        System.out.println("thread.getState() = " + thread.getState());

        thread.start();

        boolean flag = true;
        Thread.State last = null;
        while (flag) {
            if (thread.getState() != last) {
                System.out.println("thread = " + thread.getState());
                last = thread.getState();
                if (thread.getState() == Thread.State.TIMED_WAITING) {
                    thread.interrupt();
                }
            }


            if (thread.getState() == Thread.State.TERMINATED) {
                System.out.println("thread = " + thread.getState());
                flag = false;
            }
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
