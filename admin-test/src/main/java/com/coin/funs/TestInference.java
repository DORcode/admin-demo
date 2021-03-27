package com.coin.funs;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * @ClassName TestInference
 * @Description: 对象方法引用，抽象方法的第一参数类型刚好是实例方法的类型，
 * 抽象方法剩余的参数恰好可以当做实例方法的参数。如果函数接口能实现由上面说的实例方法调用来
 * 实现的话，那么就可以使用对象方法引用。
 * @Author kh
 * @Date 2021/3/27 11:58
 * @Version V1.0
 **/
public class TestInference {
    public static void main(String[] args) {
        Consumer<Too> c1 = (too) -> new Too().foo();
        c1.accept(new Too());
        Consumer<Too> c2 = Too::foo;
        c2.accept(new Too());

        test((too) -> new Too().foo(), new Too());

        BiConsumer<Too, String> c3 = (too,str) -> new Too().fun(str);
        c3.accept(new Too(), "a");

        BiConsumer<Too, String> c4 = Too::fun;
        c4.accept(new Too(), "abc");

        BiFunction<Exec, String, Integer> b1 = (e, s) -> new Exec().test(s);

        System.out.println("b1.apply(new Exec(), \"ac f\") = " + b1.apply(new Exec(), "ac f"));

        BiFunction<Exec, String, Integer> b2 = Exec::test;

        b2.apply(new Exec(), "外面");
    }

    public static void test(Consumer t, Too a) {
        t.accept(a);
    }
}

class Exec {
    public int test(String str) {
        System.out.println("str = " + str);
        return 1;
    }
}
class Too {
    public Integer fun(String s) {
        return 1;
    }

    public void foo() {
        System.out.println("true = " + true);
    }
}

class Too2 {
    public Integer fun(String s) {
        return 1;
    }

    public void foo() {
        System.out.println("true = " + true);
    }
}
