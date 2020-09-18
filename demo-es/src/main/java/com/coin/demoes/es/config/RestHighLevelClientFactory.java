package com.coin.demoes.es.config;

import com.coin.demoes.es.config.RestClientConfiguration;
import com.frameworkset.commons.pool2.PooledObject;
import com.frameworkset.commons.pool2.PooledObjectFactory;
import com.frameworkset.commons.pool2.impl.DefaultPooledObject;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RestHighLevelClientFactory
 * @Description: TODO
 * @Author kh
 * @Date 2020-09-17 17:03
 * @Version V1.0
 **/
public class RestHighLevelClientFactory implements PooledObjectFactory<RestHighLevelClient> {

    private RestClientBuilder builder;

    public RestHighLevelClientFactory(RestClientConfiguration configuration, Map<String, String> defaultHeaders) {
        builder = RestClient.builder(
                new HttpHost("localhost", 9200, "http"));

        builder.setHttpClientConfigCallback(httpAsyncClientBuilder -> {
            httpAsyncClientBuilder.setMaxConnTotal(configuration.getMaxConnectTotal());
            httpAsyncClientBuilder.setMaxConnPerRoute(configuration.getMaxConnectPerRoute());
            return httpAsyncClientBuilder;
        });

        builder.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
            @Override
            public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder requestConfigBuilder) {
                requestConfigBuilder.setConnectTimeout(configuration.getConnectTimeout());
                requestConfigBuilder.setSocketTimeout(configuration.getSocketTimeout());
                requestConfigBuilder.setConnectionRequestTimeout(configuration.getConnectionRequestTimeout());
                return requestConfigBuilder;
            }
        });

        builder.setDefaultHeaders(buildDefaultHeaders(defaultHeaders));
    }

    @Override
    public PooledObject<RestHighLevelClient> makeObject() throws Exception {
        DefaultPooledObject<RestHighLevelClient> client = new DefaultPooledObject<>(new RestHighLevelClient(builder));
        return client;
    }

    @Override
    public void destroyObject(PooledObject<RestHighLevelClient> pooledObject) throws Exception {
        pooledObject.getObject().close();
    }

    @Override
    public boolean validateObject(PooledObject<RestHighLevelClient> pooledObject) {
        try {
            return pooledObject.getObject().ping(RequestOptions.DEFAULT);
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public void activateObject(PooledObject<RestHighLevelClient> pooledObject) throws Exception {

    }

    @Override
    public void passivateObject(PooledObject<RestHighLevelClient> pooledObject) throws Exception {

    }

    private Header[] buildDefaultHeaders(Map<String, String> defaultHeaders){
        List<Header> headers = new ArrayList<>();
        if(defaultHeaders == null) {
            return headers.toArray(new Header[headers.size()]);
        }
        for(String key : defaultHeaders.keySet()){
            Header header = new BasicHeader(key, defaultHeaders.get(key));
            headers.add(header);
        }
        return headers.toArray(new Header[headers.size()]);
    }

}
