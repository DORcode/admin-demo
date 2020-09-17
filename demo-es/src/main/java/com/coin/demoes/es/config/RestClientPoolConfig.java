package com.coin.demoes.es.config;

import com.frameworkset.commons.pool2.impl.GenericObjectPool;
import com.frameworkset.commons.pool2.impl.GenericObjectPoolConfig;

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
        setMinEvictableIdleTimeMillis(60000);
        setTimeBetweenEvictionRunsMillis(30000);
        setMaxIdle(32);
        setMaxTotal(64);
        setMinIdle(16);
    }
}
