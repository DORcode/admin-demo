package com.coin.streams;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.text.Collator;
import java.util.List;
import java.util.Locale;
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
@Slf4j(topic = "MapTest")
public class MapTest {

    public static void main(String[] args) {
        List<String> collect = Stream.of(1, 2, 43, 41).map(e -> e + "2").collect(Collectors.toList());
        collect.forEach(System.out::println);

        collect.stream().map(String::length).forEach(a-> System.out.println("a = " + a));
        Stream.of("类似", "情况的什么", "作为").mapToLong(String::length).forEachOrdered(System.out::println);

        Optional<String> first = collect.stream().findFirst();
        first.ifPresent(e -> System.out.println("e = " + e));

        List<Student> students = Stream.of(Student.builder().name("存在").build(),Student.builder().name("存在").build(), Student.builder().name("小明").build(),
                Student.builder().name("阿李").build(), Student.builder().name("这子").build()).collect(Collectors.toList());
        students.stream().sorted().forEach(System.out::println);

        students.stream().peek(e -> System.out.println("e = " + e)).limit(1).peek(System.out::println);

        Optional<Student> optionalStudent = students.stream().peek(e -> System.out.println("e = " + e)).findAny();
        optionalStudent.ifPresent(System.out::println);

        log.info("\n----------");
        students.stream().distinct().forEach(System.out::println);


    }
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@EqualsAndHashCode
@ToString
class Student implements Comparable<Student> {
    String name;
    String address;
    int sex;

    @Override
    public int compareTo(Student o) {
        Collator c = Collator.getInstance(Locale.CHINA);
        return c.compare(this.name, o.name);
    }
}

class Teacher {
    String name;
    String classroom;
    List<Student> sts;
}
