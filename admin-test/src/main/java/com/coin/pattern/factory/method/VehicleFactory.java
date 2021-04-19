package com.coin.pattern.factory.method;

/**
 * @ClassName VehicleFactory
 * @Description: TODO
 * @Author kh
 * @Date 2021/4/19 21:40
 * @Version V1.0
 **/
public abstract class VehicleFactory {
    protected abstract Vehicle createVehicle(String item);

    public Vehicle orderVehicle(String size, String color) {
        Vehicle vehicle = createVehicle(size);
        vehicle.testVehicle();
        vehicle.setColor(color);
        return vehicle;
    }
}
