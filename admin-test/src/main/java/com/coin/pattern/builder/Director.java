package com.coin.pattern.builder;

/**
 * @ClassName Director
 * @Description: TODO
 * @Author kh
 * @Date 2021/4/20 22:12
 * @Version V1.0
 **/
public class Director {
    Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void direct() {
        builder.buildPart();
    }
}
