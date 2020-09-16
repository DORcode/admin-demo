package com.coin.demoes;

import org.apache.http.HttpHost;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @ClassName EsConfig
 * @Description: TODO
 * @Author kh
 * @Date 2020-09-16 17:11
 * @Version V1.0
 **/
@Configuration
public class EsConfig implements DisposableBean {

    private static int connectTimeout = 1000; // 连接超时时间
    private static int socketTimeout = 30000; // 连接超时时间
    private static int connectionRequestTimeout = 500; // 获取连接的超时时间

    private static int maxConnectNum = 100; // 最大连接数
    private static int maxConnectPerRoute = 100; // 最大路由连接数

    private RestHighLevelClient restHighLevelClient;

    @PostConstruct
    public RestHighLevelClient restHighLevelClient() {

        RestClientBuilder builder = RestClient.builder(
                new HttpHost("localhost", 9200, "http"));

        builder.setHttpClientConfigCallback(httpAsyncClientBuilder -> {
                    httpAsyncClientBuilder.setMaxConnTotal(maxConnectNum);
                    httpAsyncClientBuilder.setMaxConnPerRoute(maxConnectPerRoute);
                    return httpAsyncClientBuilder;
                });

        builder.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
            @Override
            public Builder customizeRequestConfig(Builder requestConfigBuilder) {
                requestConfigBuilder.setConnectTimeout(connectTimeout);
                requestConfigBuilder.setSocketTimeout(socketTimeout);
                requestConfigBuilder.setConnectionRequestTimeout(connectionRequestTimeout);
                return requestConfigBuilder;
            }
        });
        restHighLevelClient = new RestHighLevelClient(builder);
        return restHighLevelClient;
    }

    @Override
    public void destroy() throws Exception {

    }
}
