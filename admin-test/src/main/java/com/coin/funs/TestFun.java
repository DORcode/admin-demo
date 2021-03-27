package com.coin.funs;

import java.math.BigDecimal;
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

    public static void main(String[] args) {

        Function<String, String> func1 = (str) -> str.substring(5);
        System.out.println("func1.apply(\"abcdefg\") = " + func1.apply("abcdefg"));

        Function<Integer, BigDecimal> func2 = i -> new BigDecimal(100).divide(new BigDecimal(i), 6, BigDecimal.ROUND_FLOOR);
        System.out.println("func2.apply(12355) = " + func2.apply(12355));

        Function<String, String> func3 = TestFun::toUpper;

        System.out.printf(func3.apply("aAbBcNcBbAa"));
    }
}
