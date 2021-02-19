package com.coin.concurrent;

/**
 * @ClassName Test6
 * @Description: TODO
 * @Author kh
 * @Date 2021/2/18 21:34
 * @Version V1.0
 **/
public class Test6 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }

            System.out.println("args = " + args);
        });
        
        thread.setDaemon(true);
        thread.start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread = " + thread);
        }).start();


        System.out.println("\"thread\" = " + "thread");
    }
}