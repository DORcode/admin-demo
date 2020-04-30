package com.coin.admintest.effective.e003singleton;

/**
 * @ClassName Elvis
 * @Description: TODO
 * @Author kh
 * @Date 2020/4/25 14:09
 * @Version V1.0
 **/
public class Elvis {
    // final
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }
}
