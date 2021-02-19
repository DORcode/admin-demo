package com.coin.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName TestPark
 * @Description: TODO
 * @Author kh
 * @Date 2021/2/17 23:06
 * @Version V1.0
 **/
@Slf4j(topic = "aaa")
public class TestPark {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            log.info("park");
            LockSupport.park();
            log.info("uppark");
            LockSupport.park();
            log.info("再次park无用");

            log.info("调用清除状态", Thread.interrupted());
            LockSupport.park();
            log.info("parked");
        });

        thread.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
