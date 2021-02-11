package com.coin.tests;

/**
 * @ClassName ThreadTest
 * @Description: TODO
 * @Author kh
 * @Date 2021/2/6 20:52
 * @Version V1.0
 **/
public class ThreadTest {

    public static void main(String[] args) {
        int num = 1;
        ThreadA threadA = new ThreadA(num);
        ThreadB threadB = new ThreadB(num);
        ThreadC threadC = new ThreadC(num);
        threadC.start();
        threadB.start();
        threadA.start();
    }


    static class ThreadA extends Thread {

        int num;

        public ThreadA(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            for (int i=0; i< 100; i++) {
                if (num != 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("A");
                    num = 2;
                    notifyAll();
                }

            }
        }
    }

    static class ThreadB extends Thread {
        int num;

        public ThreadB(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            for (int i=0; i< 100; i++) {
                if (num != 2) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("B");
                    num = 3;
                    notifyAll();
                }

            }
        }
    }

    static class ThreadC extends Thread {

        int num;

        public ThreadC(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            for (int i=0; i< 100; i++) {
                if (num != 3) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("C");
                    num = 1;
                    notifyAll();
                }

            }
        }
    }
}
