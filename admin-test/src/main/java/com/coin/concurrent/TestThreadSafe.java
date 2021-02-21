package com.coin.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestThreadSafe
 * @Description: 局部变量暴露给子类，可能会导致线程安全
 * @Author kh
 * @Date 2021/2/21 15:24
 * @Version V1.0
 **/
public class TestThreadSafe {

    public static void main(String[] args) {
        ThreadSafeSub threadSafeSub = new ThreadSafeSub();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                threadSafeSub.method1();
            }).start();

        }
    }

    static class ThreadSafe {

        public void method1() {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 300; i++) {
                method2(list);
                method3(list);
            }

        }

        public void method2(List<String> list) {
            list.add("1");
        }

        public void method3(List<String> list) {
            list.remove(0);
        }
    }

    static class ThreadSafeSub extends ThreadSafe {

        @Override
        public void method3(List<String> list) {
            new Thread(() -> {
                list.remove(0);
            }).start();

        }
    }
}
