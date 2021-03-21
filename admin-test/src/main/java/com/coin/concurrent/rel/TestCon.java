package com.coin.concurrent.rel;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestCon
 * @Description: 条件
 * @Author kh
 * @Date 2021/3/20 21:32
 * @Version V1.0
 **/
public class TestCon {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        lock.lock();

        // 先要获得锁
        // 执行await后，释放锁，之后等待signal唤醒或者打断或者超时，重新竞争锁
        // 竞争锁成功后，从await后执行
        condition1.await();

        condition1.signal();

    }
}
