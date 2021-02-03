package com.coin.test.statics;

import sun.misc.Launcher;

import java.math.BigInteger;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName Son
 * @Description: TODO
 * @Author kh
 * @Date 2021-02-01 15:28
 * @Version V1.0
 **/
public class Son extends Parent {
    static {
        System.out.println("Son 静态代码块");
    }

    public Son() {
        System.out.println("Son 构造函数");
    }

    public static void main(String[] args) {
        Son son = new Son();

        Son son1 = new Son();

        String str = new BigInteger("cafebabe", 16).toString(10);
        System.out.println(str);

        String s = new BigInteger("00000037", 16).toString(10);
        System.out.println(s);

        System.out.println(Math.pow(2, 16) - 1);

        String s1 = new BigInteger("00101010", 2).toString(16);
        System.out.println(s1);

        ClassLoader classLoader = Son.class.getClassLoader();
        System.out.println("classLoader = " + classLoader);
        ClassLoader parent = classLoader.getParent();
        System.out.println("parent = " + parent);
        ClassLoader parent1 = parent.getParent();
        System.out.println("parent1 = " + parent1);

        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL ul : urLs) {
            System.out.println("ul.toExternalForm() = " + ul.toExternalForm());
        }
        Map map = new HashMap<>();
        test();
        List list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.get(0);
        list.lastIndexOf(2);
        Object[] objects = list.toArray();
        System.out.println((1112 >> 1));
        String a = "a";
        System.out.println(a.hashCode());
        int w1 = 16 | 16 >>> 1;
        System.out.println("w1 = " + w1);
        int w2 = w1 | w1 >>> 2;
        System.out.println("w2 = " + w2);
        int w3 = w2 | w2 >>> 4;
        System.out.println("w3 = " + w3);

        int w4 = w3 | w3 >>> 8;
        System.out.println("w4 = " + w4);
    }

    public static void test() throws RuntimeException {

    }
}
