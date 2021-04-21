package com.coin.pattern.builder.car;

/**
 * @ClassName ElectricCarBuilder
 * @Description: TODO
 * @Author kh
 * @Date 2021/4/20 22:46
 * @Version V1.0
 **/
public class ElectricCarBuilder {
    private Engine engine;

    public ElectricCarBuilder engine(String type) {
        return this;
    }
    public ElectricCarBuilder tank(String type) {
        return this;
    }

    public Car build() {
        Car car = new Car();
        return car;
    }
}
