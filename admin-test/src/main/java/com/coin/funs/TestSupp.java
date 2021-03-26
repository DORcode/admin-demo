package com.coin.funs;

import java.util.function.Supplier;

/**
 * @ClassName TestSupp
 * @Description: TODO
 * @Author kh
 * @Date 2021-03-26 14:42
 * @Version V1.0
 **/
public class TestSupp {

    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> {
            return 10;
        };

        System.out.println("supplier = " + supplier.get());
    }
}
