package com.coin.funs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ClassName TestConstructInf
 * @Description: TODO
 * @Author kh
 * @Date 2021/3/27 12:23
 * @Version V1.0
 **/
public class TestConstructInf {
    public static void main(String[] args) {

        Supplier<Person> s1 = () -> new Person();
        s1.get();

        Supplier<Person> s2 = Person::new;
        s2.get();

        Supplier<List> s3 = ArrayList::new;

        s3.get().add("abc");
        Supplier<Set> s4 = HashSet::new;
        s4.get().add(1);

        Supplier<Thread> s5 = Thread::new;
        Supplier<String> s6 = String::new;

        Consumer<Integer> c1 = Account::new;
        Consumer<Integer> c2 = (i) -> new Account(i);

        c1.accept(125);
        c2.accept(123);

        Function<String, Account> f1 = (s) -> new Account(s);
        Function<String, Account> f2 = Account::new;
        f1.apply("abc");

        f2.apply("cdf");

    }
}

class Person {
    public Person() {
        System.out.println("调用无参");
    }
}

class Account {
    public Account() {
        System.out.println("调用无参");
    }

    public Account(int age) {
        System.out.println("age = " + age);
    }

    public Account(String age) {
        System.out.println("age = " + age);
    }
}
