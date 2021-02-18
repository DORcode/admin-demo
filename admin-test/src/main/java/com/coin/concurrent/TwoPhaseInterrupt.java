package com.coin.concurrent;

/**
 * @ClassName TwoPhaseInterrupt
 * @Description: TODO
 * @Author kh
 * @Date 2021/2/17 22:51
 * @Version V1.0
 **/
public class TwoPhaseInterrupt {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {

            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }

                System.out.println("args = " + args);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });

        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
