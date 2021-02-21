package com.coin.concurrent;

/**
 * @ClassName Test7
 * @Description: TODO
 * @Author kh
 * @Date 2021/2/20 21:06
 * @Version V1.0
 **/
public class Test7 {
    static int counter = 0;
    final static Object lock = new Object();

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (lock) {
                    counter--;
                }

                System.out.println("a = " + i);

            }

        }, "a");

        Thread b = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (lock) {
                    counter++;
                }


                System.out.println("b = " + i);
            }
        }, "b");

        a.start();
        b.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("counter = " + counter);

        Room room = new Room();

        Thread c = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.sub();

            }

        }, "c");

        Thread d = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.increment();
            }
        }, "d");

        c.start();
        d.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("room = " + room.counter);
    }
}

class Room {
    int counter = 0;

    public void increment() {
        synchronized (this) {
            counter++;
        }
    }

    public void sub() {
        synchronized (this) {
            counter--;
        }
    }
}
