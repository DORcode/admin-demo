package com.coin.funs;

import java.util.function.Consumer;

/**
 * @ClassName TestConsumer
 * @Description: TODO
 * @Author kh
 * @Date 2021-03-26 9:26
 * @Version V1.0
 **/
public class TestConsumer {

    static int set(int i) {
        System.out.println("i = " + i);
        return  100;
    }

    void fetch(String str) {
        System.out.println("str = " + str);
    }

    public static void main(String[] args) {

        Consumer<Integer> consumer = x -> {
            x = x + 10;
            System.out.println("x = " + x);
        };

        consumer.accept(100);

        Consumer<Integer> c = TestConsumer::set;
        c.accept(10);

        Consumer<String> c2 = new TestConsumer()::fetch;
        c2.accept("year");
    }
}
