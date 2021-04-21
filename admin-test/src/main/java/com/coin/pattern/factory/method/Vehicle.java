package com.coin.pattern.factory.method;

/**
 * @ClassName Vehicle
 * @Description: TODO
 * @Author kh
 * @Date 2021/4/19 21:38
 * @Version V1.0
 **/
public interface Vehicle {
    default void testVehicle() {};
    default void setColor(String color) {};
}
