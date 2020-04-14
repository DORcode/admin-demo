package com.coin.admintest.effective.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @ClassName Pizza
 * @Description: TODO
 * @Author kh
 * @Date 2020/4/13 17:03
 * @Version V1.0
 **/
public abstract class Pizza {
    public enum Topping{HAM, MUSHROOM, ONION, PEPPER, SAUSAGE};
    private Set<Topping> toppings;

    public abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping toppings) {
            this.toppings.add(Objects.requireNonNull(toppings));
            return self();
        }

        public abstract Pizza build();

        protected abstract T self();
    }

    Pizza(Builder builder) {
        this.toppings = builder.toppings.clone();
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "toppings=" + toppings +
                '}';
    }
}
