package com.coin.pattern.builder.car;

import java.math.BigDecimal;

/**
 * @ClassName GasolineCarBuilder
 * @Description: TODO
 * @Author kh
 * @Date 2021/4/20 22:39
 * @Version V1.0
 **/
public class GasolineCarBuilder extends CarBuilder {
    @Override
    public Car buildCar() {
        Car car = new Car();

        return car;
    }

    @Override
    public void addEngine(String type) {
    }

    @Override
    public void addWheelType(String type) {

    }

    @Override
    public void paint(String color) {

    }

    @Override
    public void addTransmission(String type) {

    }

    @Override
    public void addGasTank(BigDecimal cap) {

    }

    @Override
    public void addBatteries(BigDecimal cap) {

    }
}
