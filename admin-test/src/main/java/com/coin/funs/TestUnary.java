package com.coin.funs;

import java.util.function.UnaryOperator;

/**
 * @ClassName TestUnary
 * @Description: TODO
 * @Author kh
 * @Date 2021-03-26 9:21
 * @Version V1.0
 **/
public class TestUnary {

    public static void main(String[] args) {

        UnaryOperator<String> uo = x -> x.substring(0, 2);

        System.out.println("uo.apply(\"12345\") = " + uo.apply("12345"));
    }
}
