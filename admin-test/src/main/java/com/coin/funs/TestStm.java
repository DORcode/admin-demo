package com.coin.funs;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @ClassName TestStm
 * @Description: TODO
 * @Author kh
 * @Date 2021/3/27 14:08
 * @Version V1.0
 **/
public class TestStm {

    public static void main(String[] args) {

        Stream<Integer> s1 = Stream.generate(() -> 1);
        s1.limit(1).forEach(System.out::println);

        Stream.iterate(1, x -> x + 1).limit(10).forEach(System.out::println);

        String str = "abcdefg";
        str.chars().forEach(System.out::println);
        List<Integer> integers = Arrays.asList(1, 5, 7, 2, 4, 22, 13, 78, 36, 99);
        Optional<Integer> max = integers.stream().max((a, b) -> a - b);
        System.out.println("max.re = " + max.get());
        Optional<Integer> first = integers.stream().sorted((x, y) -> x - y).findFirst();
        System.out.println("first = " + first.get());

        int sum = Stream.of("1,2,5,16".split(",")).mapToInt(Integer::parseInt).sum();
        System.out.println("sum = " + sum);


    }
}
