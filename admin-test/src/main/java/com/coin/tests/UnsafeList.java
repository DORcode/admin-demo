package com.coin.tests;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UnsafeList
 * @Description: TODO
 * @Author kh
 * @Date 2021/2/16 13:56
 * @Version V1.0
 **/
public class UnsafeList {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {

            new Thread(() -> {
               names.add(Thread.currentThread().getName());
            }).start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("names = " + names.size());
    }
}
