package com.coin.sphere;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ShardingSphereConfig
 * @Description: TODO
 * @Author kh
 * @Date 2020-12-08 9:53
 * @Version V1.0
 **/
// @Configuration
public class ShardingSphereConfig {

    @ConfigurationProperties(prefix = "spring.shardingsphere.datasource.ds0")
    @Bean(name = "ds0")
    public DataSource dataSource0() {
        return new HikariDataSource();
    }

    @ConfigurationProperties(prefix = "spring.shardingsphere.datasource.ds1")
    @Bean(name = "ds1")
    public DataSource dataSource1() {
        return new HikariDataSource();
    }

    @Primary
    @Bean("")
    public DataSource dataSource(@Qualifier("ds0") DataSource ds0, @Qualifier("ds1") DataSource ds1) {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("ds0", ds0);
        dataSourceMap.put("ds1", ds1);
        ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();
        return null;
    }
}
