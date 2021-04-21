package com.coin.pattern.builder;

/**
 * @ClassName ProductBuilder
 * @Description: TODO
 * @Author kh
 * @Date 2021/4/20 22:10
 * @Version V1.0
 **/
public class ProductBuilder extends Builder {
    private String name;
    @Override
    public void buildPart() {
        name = "";
    }

    public Product get() {
        Product product = new Product();
        product.setName(name);
        return product;
    }
}
