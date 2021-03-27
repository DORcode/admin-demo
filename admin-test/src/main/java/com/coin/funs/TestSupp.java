package com.coin.funs;

import java.util.function.Supplier;

/**
 * @ClassName TestSupp
 * @Description: TODO
 * @Author kh
 * @Date 2021-03-26 14:42
 * @Version V1.0
 **/
public class TestSupp {

    public String put() {
        return "put";
    }

    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> {
            return 10;
        };

        System.out.println("supplier = " + supplier.get());

        Supplier<String> s2 = () -> "abc";

        System.out.println("s2.get() = " + s2.get());

        Supplier<String> s3 = TestSupp::get;
        System.out.printf("", s3.get());

        Supplier<String> s4 = () -> new TestSupp().put();

        Supplier<String> s5 = new TestSupp()::put;
        System.out.println("s4 = " + s4.get());
        System.out.println("s5 = " + s5.get());
    }

    static String get() {
        System.out.println("\"get\" = " + "get");
        return "get";
    }
}
