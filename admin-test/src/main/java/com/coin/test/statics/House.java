package com.coin.test.statics;

/**
 * @ClassName House
 * @Description: TODO
 * @Author kh
 * @Date 2021-02-05 10:42
 * @Version V1.0
 **/
public class House<T> {

    private T item;

    public House() {
    }

    public House(T item) {
        this.item = item;
    }
}
