package com.coin.pattern.builder;

import java.math.BigDecimal;

/**
 * @ClassName Product
 * @Description: TODO
 * @Author kh
 * @Date 2021/4/20 22:08
 * @Version V1.0
 **/
public class Product {
    private String name;
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
