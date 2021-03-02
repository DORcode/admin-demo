package com.coin.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @ClassName TestTransfer
 * @Description: TODO
 * @Author kh
 * @Date 2021/2/21 20:51
 * @Version V1.0
 **/
@Slf4j(topic = "transfer")
public class TestTransfer {
    static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        Account a = new Account(1000);
        Account b = new Account(1000);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                a.transfer(b, random.nextInt(100) + 1);
            }
        }, "a");
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                b.transfer(a, random.nextInt(100) + 1);
            }
        }, "b");
        t2.start();

        t1.join();
        t2.join();

        System.out.println("a.getCount() + b.getCount() = " + (a.getCount() + b.getCount()));


    }
}

class Account {
    int count;

    public Account(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void transfer(Account target, int num) {
        synchronized (Account.class) { // 此处是两个不同的类，用this还是存在线程安全问题
            if (getCount() > num) {
                setCount(getCount() - num);
                target.setCount(target.getCount() + num);
            }
        }
    }
}
