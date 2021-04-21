package com.coin.pattern.builder.car;

import java.math.BigDecimal;

/**
 * @ClassName CarBuilderDirector
 * @Description: TODO
 * @Author kh
 * @Date 2021/4/20 22:40
 * @Version V1.0
 **/
public class CarBuilderDirector {

    public Car buildGasolineCar(CarBuilder builder) {
        builder.addBatteries(new BigDecimal("1.1"));
        builder.addTransmission("a");
        builder.addEngine("c");
        return builder.buildCar();
    }
}
