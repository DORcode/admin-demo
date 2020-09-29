package com.coin.demoes;

import com.coin.demoes.es.config.ElasticsearchClientFactory;
import com.coin.demoes.es.config.RestClientConfiguration;
import com.coin.demoes.es.config.RestClientPoolConfig;
import com.coin.demoes.es.config.RestClientTemplate;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName EsConfig
 * @Description: TODO
 * @Author kh
 * @Date 2020-09-16 17:11
 * @Version V1.0
 **/
@Configuration
public class EsConfig {

    @Value("${es.host}")
    private String esHost;

    @Bean
    public ElasticsearchClientFactory elasticsearchClientFactory() {
        RestClientPoolConfig restClientPoolConfig = new RestClientPoolConfig();
        restClientPoolConfig.setMinIdle(16);
        restClientPoolConfig.setMaxTotal(32);
        restClientPoolConfig.setMaxIdle(32);
        restClientPoolConfig.setMaxWaitMillis(8000);
        RestClientConfiguration restClientConfiguration = new RestClientConfiguration();
        restClientConfiguration.setEsHost(esHost);
        restClientConfiguration.setConnectTimeout(1000);
        restClientConfiguration.setConnectionRequestTimeout(500);
        restClientConfiguration.setSocketTimeout(20000);
        restClientConfiguration.setMaxConnectTotal(100);
        restClientConfiguration.setMaxConnectTotal(100);
        Map<String, String> defaultHeaders = new HashMap<>();
        ElasticsearchClientFactory elasticsearchClientFactory = new ElasticsearchClientFactory(restClientConfiguration, restClientPoolConfig);
        elasticsearchClientFactory.setDefaultHeaders(defaultHeaders);
        return elasticsearchClientFactory;
    }

    @Bean
    public RestClientTemplate restClientTemplate() {
        RestClientTemplate restClientTemplate = new RestClientTemplate(elasticsearchClientFactory());
        return restClientTemplate;
    }
}
