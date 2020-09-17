package com.coin.demoes.es.config;

import org.elasticsearch.client.RestHighLevelClient;

/**
 * @ClassName EsRestTemplate
 * @Description: TODO
 * @Author kh
 * @Date 2020-09-17 18:43
 * @Version V1.0
 **/
public class RestClientTemplate {
    ElasticsearchClientFactory elasticsearchClientFactory;

    public RestClientTemplate(ElasticsearchClientFactory elasticsearchClientFactory) {
        this.elasticsearchClientFactory = elasticsearchClientFactory;
    }

    public <T> T execute(RestClientCallback<T> callback) {
        RestHighLevelClient client = this.elasticsearchClientFactory.getResource();
        T t = callback.request(client);
        this.elasticsearchClientFactory.returnObject(client);
        return t;
    }
}
