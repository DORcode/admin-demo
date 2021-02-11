package com.coin.tests;

/**
 * @ClassName Parent
 * @Description: TODO
 * @Author kh
 * @Date 2021-02-01 15:26
 * @Version V1.0
 **/
public class Parent {
    static {
        System.out.println("Parent 静态代码块");
    }

    public Parent() {
        System.out.println("Parent 构造方法");
    }
}
