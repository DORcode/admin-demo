package com.coin.demoes.es.config;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.DisposableBean;

import java.io.Closeable;
import java.io.IOException;

/**
 * @ClassName RestClientPool
 * @Description: TODO
 * @Author kh
 * @Date 2020-09-17 17:31
 * @Version V1.0
 **/
public class RestClientPool<T> implements Closeable {

    GenericObjectPool<T> pool;

    public RestClientPool(PooledObjectFactory<T> factory,
                          GenericObjectPoolConfig<T> config) {
        initPool(factory, config);
    }

    private  void initPool(PooledObjectFactory<T> factory,
                           GenericObjectPoolConfig<T> config) {
        if(pool != null) {
            closePool();
        }
        pool = new GenericObjectPool<T>(factory, config);
    }

    public T getResource() {
        try {
            return pool.borrowObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public void returnObject(T t) {
        if(t != null) {
            try {
                pool.returnObject(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getNumActive() {
        if(!isPoolActive()) {
            return -1;
        }
        return pool.getNumActive();
    }

    public boolean isPoolActive() {
        return pool != null && !pool.isClosed();
    }

    private void closePool() {
        try {
            pool.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        this.closePool();
    }


    public void addObjects(int count) {
        try {
            for(int i = 0; i < count; i++) {
                this.pool.addObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
