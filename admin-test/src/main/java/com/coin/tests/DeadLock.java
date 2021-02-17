package com.coin.tests;

/**
 * @ClassName DeadLock
 * @Description: TODO
 * @Author kh
 * @Date 2021/2/16 20:31
 * @Version V1.0
 **/
public class DeadLock {

    public static void main(String[] args) {
        new Thread(new Makeup(0), "a").start();
        new Thread(new Makeup(1), "b").start();
    }
}

class Makeup implements Runnable {
    static Mirror mirror = new Mirror();
    static LipStick lipStick = new LipStick();
    int choice = 0;

    public Makeup(int choice) {
        this.choice = choice;
    }

    @Override
    public void run() {
        if (this.choice == 0) {
            synchronized (mirror) {
                System.out.println(Thread.currentThread().getName() + "mirror = " + mirror);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipStick) {
                    System.out.println(Thread.currentThread().getName() + "lipStick = " + lipStick);
                }

            }


        } else {
            synchronized (lipStick) {
                System.out.println(Thread.currentThread().getName() + "lipStick = " + lipStick);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (mirror) {
                    System.out.println(Thread.currentThread().getName() + "mirror = " + mirror);
                }
            }


        }
    }
}

class Mirror {

}

class LipStick {

}
