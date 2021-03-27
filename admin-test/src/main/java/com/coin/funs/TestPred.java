package com.coin.funs;

import org.apache.commons.lang.StringUtils;

import java.util.function.Predicate;

/**
 * @ClassName TestPred
 * @Description: TODO
 * @Author kh
 * @Date 2021/3/27 18:15
 * @Version V1.0
 **/
public class TestPred {

    public static void main(String[] args) {

        Predicate<String> p = s -> !s.isEmpty();

        Predicate<String> p2 = s -> s.endsWith("a");

        Predicate<String> p3 = StringUtils::isNotEmpty;

        System.out.println("p.test(\"\") = " + p.test(""));
        System.out.println("p.and(p2).test(\"bbb\") = " + p.and(p2).and(p3).test("bbba"));

        System.out.println(p2.or(p3).test("bbb"));
    }
}
