package com.coin.tests;

/**
 * @ClassName Test
 * @Description: TODO
 * @Author kh
 * @Date 2021/4/3 19:54
 * @Version V1.0
 **/
public class Test {

    public static void main(String[] args) {
        Dad son = new Son();
        System.out.println(son.i);
    }

    static class Dad {
        int i = 10;

        public Dad() {
            System.out.println("dad");
            print();
            i = 20;
        }

        public void print() {
            System.out.println("dad = " + i);
        }
    }

    static class Son extends Dad {

        int i = 30;

        public Son() {
            System.out.println("son");
            print();
            i = 40;
        }

       @Override
        public void print() {
            System.out.println("son = " + i);
        }
    }
}





