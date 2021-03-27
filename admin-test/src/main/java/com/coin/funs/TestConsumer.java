package com.coin.funs;

import java.util.function.Consumer;
import java.util.stream.Stream;

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

        method("heLLo", (str) -> {
            System.out.println("str.toUpperCase() = " + str.toUpperCase());
        }, (str) -> {
            System.out.println("str.toLowerCase() = " + str.toLowerCase());
        });

        String[] array = {"迪,女", "古,女", "马,男"};

        Stream.of(array).forEach(e -> {
            print(str -> System.out.print("姓名：" + str.split(",")[0]),
                    str -> System.out.println(" 性别：" + str.split(",")[1]), e);
        });
    }

    public static void method(String s, Consumer<String> c1, Consumer<String> c2) {
//        c1.accept(s);
//        c2.accept(s);
        c1.andThen(c2).accept(s);
    }

    public static void print(Consumer<String> c1, Consumer<String> c2, String s) {
        c1.andThen(c2).accept(s);
    }
}
