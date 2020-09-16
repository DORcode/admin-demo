package com.coin.demoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class DemoEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEsApplication.class, args);
    }

}
