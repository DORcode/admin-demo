package com.coin.test.statics;

import sun.misc.Launcher;

import javax.validation.constraints.Negative;
import java.math.BigInteger;
import java.net.URL;
import java.util.*;
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

        Arrays.asList("a", "b", "c").forEach(c -> {
            System.out.println("c = " + c);
        });

        List a1 = new ArrayList();
        a1.add(new Object());
        a1.add("aaa");
        a1.add(111);
        List<Object> a2 = a1;
        System.out.println("a2 = " + a2);

        List<Integer> a3 = a1;
        a3.add(123);
        System.out.println("a3 = " + a3);

        List<?> a4 = a1;

        System.out.println("a4 = " + a4);

        List<Parent> parents1 = new ArrayList<>();
        List<Son> sons = new ArrayList<>();
        parents1.add(new Parent());
        List<? extends Parent> parents = parents1;
        parents.get(0);

        List<? extends Parent> parents2 = sons;

        List<? super Son> son2 = new ArrayList<>();
        son2.add(new Son());
        // son2.add(new Parent());
        son2.add(new S());
        Map<Object, Object> map1 = new HashMap<>();
        map1.put(2, 1);
        map1.put(null, 2);
        map1.put(null, 3);
        System.out.println("map1 = " + map1.toString());

        // array转list
        List<String> objects1 = new ArrayList<>(Arrays.asList("1", "2"));
        objects1.add("15");
        System.out.println("objects1 = " + objects1);

        String[] strings = new String[3];
        objects1.toArray(strings);
        System.out.println("strings = " + strings);
        for (String s2 : strings) {
            System.out.println("s1 = " + s2);
        }

        House<? extends Parent> parentHouse = new House<Son>();
    }

    public static void test() throws RuntimeException {

    }
}
