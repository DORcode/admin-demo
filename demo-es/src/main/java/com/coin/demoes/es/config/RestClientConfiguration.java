package com.coin.demoes.es.config;

/**
 * @ClassName RestHighLevelClientConfiguration
 * @Description: TODO
 * @Author kh
 * @Date 2020-09-17 17:16
 * @Version V1.0
 **/
public class RestClientConfiguration {

    /**
     * 连接超时时间
     */
    private int connectTimeout = 1000;

    /**
     * 连接超时时间
     */
    private int socketTimeout = 30000;

    /**
     * 获取连接的超时时间
     */
    private int connectionRequestTimeout = 500;

    /**
     * 最大连接数
     */
    private int maxConnectTotal = 100;

    /**
     * 最大路由连接数
     */
    private int maxConnectPerRoute = 100;

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public int getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    public int getMaxConnectTotal() {
        return maxConnectTotal;
    }

    public void setMaxConnectTotal(int maxConnectTotal) {
        this.maxConnectTotal = maxConnectTotal;
    }

    public int getMaxConnectPerRoute() {
        return maxConnectPerRoute;
    }

    public void setMaxConnectPerRoute(int maxConnectPerRoute) {
        this.maxConnectPerRoute = maxConnectPerRoute;
    }
}
