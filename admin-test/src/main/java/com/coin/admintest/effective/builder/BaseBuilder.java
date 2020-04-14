package com.coin.admintest.effective.builder;

/**
 * @ClassName BaseBuilder
 * @Description: TODO
 * @Author kh
 * @Date 2020/4/13 17:26
 * @Version V1.0
 **/
public abstract class BaseBuilder {

    public abstract static class Builder<T extends Builder<T>> {
        protected abstract BaseBuilder build();
        protected abstract T self();
    }

    BaseBuilder(Builder builder) {
    }
}
