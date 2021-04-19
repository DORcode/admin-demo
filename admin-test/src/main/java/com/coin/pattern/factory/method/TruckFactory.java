package com.coin.pattern.factory.method;

/**
 * @ClassName TruckFactory
 * @Description: TODO
 * @Author kh
 * @Date 2021/4/19 21:46
 * @Version V1.0
 **/
public class TruckFactory extends VehicleFactory {
    @Override
    protected Vehicle createVehicle(String item) {
        return new Truck();
    }
}
