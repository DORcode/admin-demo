package com.coin.admintest.effective.e002builder;

import java.math.BigDecimal;

/**
 * @ClassName Apple
 * @Description: TODO
 * @Author kh
 * @Date 2020/4/13 17:29
 * @Version V1.0
 **/
public class Apple extends BaseBuilder {
    private String name;
    private String size;
    private BigDecimal price;

    Apple(Builder builder) {
        super(builder);
        this.name = builder.name;
        this.size = builder.size;
        this.price = builder.price;
    }

    public static class Builder extends BaseBuilder.Builder<Builder> {
        private String name;
        private String size;
        private BigDecimal price;

        public Builder name(String name) {
            this.name = name;
            return self();
        }

        public Builder size(String size) {
            this.size = size;
            return self();
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return self();
        }

        @Override
        protected BaseBuilder build() {
            return new Apple(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}
