package com.coin.pattern.factory.simple;

/**
 * @ClassName VehicleFactory
 * @Description: TODO
 * @Author kh
 * @Date 2021-04-19 11:35
 * @Version V1.0
 **/
public class VehicleFactory {
    public enum VehicleType {
        Bike, Car, Truck;
    }

    public static Vehicle create(VehicleType type) {
        if (type.equals(VehicleType.Car)) {
            return new Car();
        } else if (type.equals(VehicleType.Bike)) {
            return new Bike();
        } else {
            return null;
        }
    }
}
