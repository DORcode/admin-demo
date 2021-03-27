package com.coin.funs;

import java.math.BigDecimal;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @ClassName TestFun
 * @Description: TODO
 * @Author kh
 * @Date 2021-03-26 14:45
 * @Version V1.0
 **/
public class TestFun {

    static String toUpper(String s) {
        return s.toUpperCase();
    }

    static Integer len(String l, String r) {
        return l.length() * r.length();
    }


    String concat(String str) {
        return str.concat("dfe");
    }


    public static void main(String[] args) {

        Function<String, String> func1 = (str) -> str.substring(5);
        System.out.println("func1.apply(\"abcdefg\") = " + func1.apply("abcdefg"));

        Function<Integer, BigDecimal> func2 = i -> new BigDecimal(100).divide(new BigDecimal(i), 6, BigDecimal.ROUND_FLOOR);
        System.out.println("func2.apply(12355) = " + func2.apply(12355));

        Function<String, String> func3 = TestFun::toUpper;

        System.out.printf(func3.apply("aAbBcNcBbAa"));

        BiFunction<String, String, Integer> func4 = TestFun::len;

        System.out.println(func4.apply("abc", "xyz"));

        Function<String, String> func5 = new TestFun()::concat;
        System.out.println("func5 = " + func5.apply("flh"));


    }
}
