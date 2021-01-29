package com.coin.es.config;

import org.elasticsearch.client.RestHighLevelClient;

import java.util.Map;

/**
 * @ClassName ElasticsearchClientFactory
 * @Description: TODO
 * @Author kh
 * @Date 2020-09-17 17:51
 * @Version V1.0
 **/
public class ElasticsearchClientFactory {

    RestClientPool<RestHighLevelClient> restClientPool;
    Map<String, String> defaultHeaders;

    public ElasticsearchClientFactory(RestClientConfiguration configuration, RestClientPoolConfig poolConfig) {
        createPool(configuration, poolConfig);
    }

    public void setDefaultHeaders(Map<String, String> defaultHeaders) {
        this.defaultHeaders = defaultHeaders;
    }

    public RestHighLevelClient getResource() {
        return restClientPool.getResource();
    }

    public void returnObject(RestHighLevelClient client) {
        restClientPool.returnObject(client);
    }

    public void close() {
        this.restClientPool.close();
    }

    public void createPool(RestClientConfiguration configuration, RestClientPoolConfig poolConfig) {
        RestHighLevelClientFactory clientFactory = new RestHighLevelClientFactory(configuration, defaultHeaders);
        restClientPool = new RestClientPool<RestHighLevelClient>(clientFactory, poolConfig);
    }
}
