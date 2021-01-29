package com.coin.es.config;

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
        RestHighLevelClient client = null;
        try {
            client = this.elasticsearchClientFactory.getResource();
            T t = callback.request(client);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            if(null != client) {
                this.elasticsearchClientFactory.returnObject(client);
            }

        }
    }
}
