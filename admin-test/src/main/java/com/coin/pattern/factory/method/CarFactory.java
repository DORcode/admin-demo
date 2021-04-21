package com.coin.pattern.factory.method;

/**
 * @ClassName CarFactory
 * @Description: TODO
 * @Author kh
 * @Date 2021/4/19 21:43
 * @Version V1.0
 **/
public class CarFactory extends VehicleFactory {
    @Override
    protected Vehicle createVehicle(String item) {
        if (item.equals("small")) {
            return new SportCar();
        } else {
            return new SedanCar();
        }

    }
}
