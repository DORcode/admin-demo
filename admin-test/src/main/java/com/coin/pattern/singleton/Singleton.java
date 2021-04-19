package com.coin.pattern.singleton;

/**
 * @ClassName Singleton
 * @Description: TODO
 * @Author kh
 * @Date 2021-04-19 11:15
 * @Version V1.0
 **/
public class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (null == singleton) {
            synchronized (Singleton.class) {
                if (null == singleton) {
                    singleton = new Singleton();
                }
            }

        }
        return singleton;
    }
}
