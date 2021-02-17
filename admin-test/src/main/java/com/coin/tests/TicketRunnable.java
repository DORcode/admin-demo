package com.coin.tests;

/**
 * @ClassName TicketRunnable
 * @Description: TODO
 * @Author kh
 * @Date 2021/2/15 20:56
 * @Version V1.0
 **/
public class TicketRunnable implements Runnable {
    private int num = 10;

    @Override
    public void run() {
        while (true) {
            if (num <= 0) {
                break;
            }
            synchronized (this) {
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + "num-- = " + num--);
                }

            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }
    }

    public static void main(String[] args) {
        TicketRunnable ticketRunnable = new TicketRunnable();

        new Thread(ticketRunnable, "小明").start();
        new Thread(ticketRunnable, "小文").start();
        new Thread(ticketRunnable, "小红").start();
    }
}
