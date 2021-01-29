package com.coin.es;

import com.coin.es.config.ElasticsearchClientFactory;
import com.coin.es.config.RestClientConfiguration;
import com.coin.es.config.RestClientPoolConfig;
import com.coin.es.config.RestClientTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    @Value("${es.scheme}")
    private String scheme;

    @Bean
    public ElasticsearchClientFactory elasticsearchClientFactory() {
        RestClientPoolConfig restClientPoolConfig = new RestClientPoolConfig();
        restClientPoolConfig.setMinIdle(16);
        restClientPoolConfig.setMaxTotal(32);
        restClientPoolConfig.setMaxIdle(32);
        restClientPoolConfig.setMaxWaitMillis(8000);
        RestClientConfiguration restClientConfiguration = new RestClientConfiguration();
        restClientConfiguration.setEsHost(esHost);
        restClientConfiguration.setScheme(scheme);
        restClientConfiguration.setConnectTimeout(1000);
        restClientConfiguration.setConnectionRequestTimeout(500);
        restClientConfiguration.setSocketTimeout(20000);
        restClientConfiguration.setMaxConnectTotal(100);
        restClientConfiguration.setMaxConnectTotal(100);
        Map<String, String> defaultHeaders = new HashMap<>();
        ElasticsearchClientFactory elasticsearchClientFactory = new ElasticsearchClientFactory(restClientConfiguration,
                restClientPoolConfig);
        elasticsearchClientFactory.setDefaultHeaders(defaultHeaders);
        return elasticsearchClientFactory;
    }

    @Bean
    public RestClientTemplate restClientTemplate() {
        RestClientTemplate restClientTemplate = new RestClientTemplate(elasticsearchClientFactory());
        return restClientTemplate;
    }
}
