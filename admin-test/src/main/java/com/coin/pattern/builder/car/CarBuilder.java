package com.coin.pattern.builder.car;

import java.math.BigDecimal;

/**
 * @ClassName CarBuilder
 * @Description: TODO
 * @Author kh
 * @Date 2021/4/20 22:33
 * @Version V1.0
 **/
public abstract class  CarBuilder {
    private Engine engine;
    private Wheel wheel;
    public abstract Car buildCar();
    public abstract void addEngine(String type);
    public abstract void addWheelType(String type);
    public abstract void paint(String color);
    public abstract void addTransmission(String type);
    public abstract void addGasTank(BigDecimal cap);
    public abstract void addBatteries(BigDecimal cap);

}
