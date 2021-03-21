package com.coin.concurrent.rel;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Phiosophy
 * @Description: TODO
 * @Author kh
 * @Date 2021/3/20 11:22
 * @Version V1.0
 **/
@Slf4j(topic = "Phiosophy")
public class Phiosophy extends Thread {

    Chopstick left;
    Chopstick right;
    String name;

    public Phiosophy(String name, Chopstick left, Chopstick right) {
        super(name);
        this.left = left;
        this.right = right;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (left.tryLock()) {
                if (right.tryLock()) {
                    eat();
                    try {

                    } finally {
                        right.unlock();
                    }
                }
                try {

                } finally {
                    left.unlock();
                }
            }

        }
    }

    public void eat() {
        log.info("{}吃饭", name);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Chopstick ch1 = new Chopstick(1);
        Chopstick ch2 = new Chopstick(2);
        Chopstick ch3 = new Chopstick(3);
        Chopstick ch4 = new Chopstick(4);
        Chopstick ch5 = new Chopstick(5);

        new Phiosophy("孔子", ch1, ch2).start();
        new Phiosophy("孟子", ch2, ch3).start();
        new Phiosophy("老子", ch3, ch4).start();
        new Phiosophy("庄子", ch4, ch5).start();
        new Phiosophy("默子", ch1, ch5).start();// 把5和1换位置，不会出现死锁，介会出现饥饿

    }
}

@AllArgsConstructor
class Chopstick extends ReentrantLock {
    int num;
}
