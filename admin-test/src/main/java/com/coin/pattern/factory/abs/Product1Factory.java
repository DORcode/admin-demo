package com.coin.pattern.factory.abs;

/**
 * @ClassName Product1Factory
 * @Description: TODO
 * @Author kh
 * @Date 2021/4/19 22:10
 * @Version V1.0
 **/
public class Product1Factory extends BaseFactory {
    @Override
    public BaseProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public BaseProductB createProductB() {
        return new ProductB1();
    }
}
