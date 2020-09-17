package com.coin.demoes.es.config;

import org.elasticsearch.client.RestHighLevelClient;

/**
 * @ClassName RestClientCallback
 * @Description: TODO
 * @Author kh
 * @Date 2020-09-17 19:05
 * @Version V1.0
 **/
public interface RestClientCallback<T> {
    T request(RestHighLevelClient client);
}
