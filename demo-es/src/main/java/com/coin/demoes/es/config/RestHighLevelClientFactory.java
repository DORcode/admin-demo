package com.coin.demoes.es.config;

import com.coin.demoes.es.config.RestClientConfiguration;
import com.fasterxml.jackson.core.JsonFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.*;
import org.elasticsearch.client.sniff.ElasticsearchNodesSniffer;
import org.elasticsearch.client.sniff.SniffOnFailureListener;
import org.elasticsearch.client.sniff.Sniffer;

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

    private static final Log logger = LogFactory.getLog(RestHighLevelClientFactory.class);

    private RestClientBuilder builder;

    public RestHighLevelClientFactory(RestClientConfiguration configuration, Map<String, String> defaultHeaders) {

        String[] split = configuration.getEsHost().split(",");
        HttpHost[] httpHosts = new HttpHost[split.length];
        for(int i = 0; i < split.length; i++) {
            String[] strs = split[i].split(":");
            HttpHost httpHost = new HttpHost(strs[0], Integer.parseInt(strs[1]), configuration.getScheme());
            httpHosts[i] = httpHost;
        }
        builder = RestClient.builder(httpHosts);

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
            boolean ping = pooledObject.getObject().ping(RequestOptions.DEFAULT);
            List<Node> nodes = pooledObject.getObject().getLowLevelClient().getNodes();
            logger.info(nodes.toString());
            ElasticsearchNodesSniffer elasticsearchNodesSniffer = new ElasticsearchNodesSniffer(pooledObject.getObject().getLowLevelClient());
            List<Node> sniff = elasticsearchNodesSniffer.sniff();
            if(sniff.size() > nodes.size()) {
                pooledObject.getObject().getLowLevelClient().setNodes(sniff);
            }
            logger.info(sniff.toString());
            return ping;
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
