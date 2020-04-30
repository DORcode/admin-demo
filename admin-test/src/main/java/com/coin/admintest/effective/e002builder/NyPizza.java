package com.coin.admintest.effective.e002builder;

/**
 * @ClassName NyPizza
 * @Description: TODO
 * @Author kh
 * @Date 2020/4/13 17:11
 * @Version V1.0
 **/
public class NyPizza extends Pizza {
    private enum Size {SMALL, MEDIUM, LARGE};
    private Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private Size size;

        public Builder(Size size) {
            this.size = size;
        }

        @Override
        public Pizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    NyPizza(Builder builder) {
       super(builder);
       this.size = builder.size;
    }

    @Override
    public String toString() {
        return "NyPizza{" +
                "size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Pizza pizza = new Builder(Size.LARGE).addTopping(Topping.HAM).build();
        System.out.println("pizza = " + pizza.toString());

        BaseBuilder build = new Apple.Builder().name("阿克苏").build();
        System.out.println("build.toString() = " + build.toString());
    }
}
