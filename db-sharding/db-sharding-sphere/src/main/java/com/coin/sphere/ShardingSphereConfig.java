package com.coin.sphere;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.springframework.context.annotation.Configuration;

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
public class ShardingSphereConfig {
    public DataSource dataSource() {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        HikariDataSource dataSource0 = new HikariDataSource();
        dataSource0.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource0.setJdbcUrl("jdbc:mysql://localhost:3306/ds0");
        dataSource0.setUsername("root");
        dataSource0.setPassword("");
        dataSourceMap.put("ds0", dataSource0);

        HikariDataSource dataSource1 = new HikariDataSource();
        dataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource1.setJdbcUrl("jdbc:mysql://localhost:3306/ds1");
        dataSource1.setUsername("root");
        dataSource1.setPassword("");
        dataSourceMap.put("ds1", dataSource1);
        return null;
    }
}
