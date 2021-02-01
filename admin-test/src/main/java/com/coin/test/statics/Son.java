package com.coin.test.statics;

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

    }
}
