package com.coin.streams;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName MapTest
 * @Description: TODO
 * @Author kh
 * @Date 2021-03-18 11:40
 * @Version V1.0
 **/
//@Slf4j(topic = "MapTest")
public class MapTest {

    public static void main(String[] args) {
        List<String> collect = Stream.of(1, 2, 43, 41).map(e -> e + "2").collect(Collectors.toList());
        collect.forEach(System.out::println);

        collect.stream().map(String::length).forEach(a-> System.out.println("a = " + a));
        Stream.of("类似", "情况的什么", "作为").mapToLong(String::length).forEachOrdered(System.out::println);

        Optional<String> first = collect.stream().findFirst();
        first.ifPresent(e -> System.out.println("e = " + e));


    }
}

@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode
class Student {
    String name;
    String address;
    int sex;
}

class Teacher {
    String name;
    String classroom;
}
