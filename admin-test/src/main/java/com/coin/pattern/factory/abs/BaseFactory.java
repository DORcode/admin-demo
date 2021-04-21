package com.coin.pattern.factory.abs;

/**
 * @ClassName BaseFactory
 * @Description: TODO
 * @Author kh
 * @Date 2021/4/19 22:09
 * @Version V1.0
 **/
public abstract class BaseFactory {
    public abstract BaseProductA createProductA();
    public abstract BaseProductB createProductB();
}
