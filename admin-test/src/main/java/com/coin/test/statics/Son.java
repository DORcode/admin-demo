package com.coin.test.statics;

import java.math.BigInteger;

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

    }
}
