package com.coin.tests;

/**
 * @ClassName Race
 * @Description: TODO
 * @Author kh
 * @Date 2021/2/15 21:17
 * @Version V1.0
 **/
public class Race implements Runnable {
    private static String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 1) {
                try {
                    Thread.sleep(0, 11);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (winner != null) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了第" + i + "步");
            if (i == 100) {
                winner = Thread.currentThread().getName();
                System.out.println(Thread.currentThread().getName() + "赢得了比赛");
            }
        }
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
