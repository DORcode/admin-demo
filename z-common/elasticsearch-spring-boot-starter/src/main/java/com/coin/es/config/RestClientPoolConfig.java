package com.coin.es.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * @ClassName RestClientPoolConfig
 * @Description: TODO
 * @Author kh
 * @Date 2020-09-17 17:44
 * @Version V1.0
 **/
public class RestClientPoolConfig extends GenericObjectPoolConfig {

    public RestClientPoolConfig() {
        setTestWhileIdle(true);
        setMinEvictableIdleTimeMillis(30000);
        setTimeBetweenEvictionRunsMillis(60000);
        setMaxIdle(32);
        setMaxTotal(64);
        setMinIdle(16);
    }
}
