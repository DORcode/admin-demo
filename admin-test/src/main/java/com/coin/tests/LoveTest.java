package com.coin.tests;

/**
 * @ClassName LoveTest
 * @Description: TODO
 * @Author kh
 * @Date 2021/2/16 9:57
 * @Version V1.0
 **/
public class LoveTest {

    public static void main(String[] args) {
        Love love = a -> {
            System.out.println("a = " + a);
        };
        love.love(10);

        love(a -> {
            System.out.println("a = " + a);
        }, 101);
    }

    static void love(Love love, int a) {
        love.love(a);
    }

    static interface Love {
        void love(int a);
    }
}
