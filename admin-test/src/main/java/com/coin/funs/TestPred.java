package com.coin.funs;

import org.apache.commons.lang.StringUtils;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @ClassName TestPred
 * @Description: TODO
 * @Author kh
 * @Date 2021/3/27 18:15
 * @Version V1.0
 **/
public class TestPred {

    public static void main(String[] args) {

        Predicate<String> p = s -> s.isEmpty();

        Predicate<String> p2 = s -> s.endsWith("a");

        Predicate<String> p3 = StringUtils::isNotEmpty;

        System.out.println("p.test(\"\") = " + p.negate().test(""));
        System.out.println("p.and(p2).test(\"bbb\") = " + p.negate().and(p2).and(p3).test("bbba"));

        System.out.println(p2.or(p3).test("bbb"));

        System.out.println(p2.negate().test("bbba"));

        Predicate<String> p4 = s -> s.split(",")[0].length() == 1;
        Predicate<String> p5 = s -> s.split(",")[1].equals("女");

        String[] array = {"迪,女", "古,女", "马,男"};

        Stream.of(array).filter(p4.and(p5)).forEach(System.out::println);
    }
}
