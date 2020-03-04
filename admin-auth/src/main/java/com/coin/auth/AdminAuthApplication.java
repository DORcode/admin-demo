package com.coin.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.coin.auth.web.mapper")
public class AdminAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminAuthApplication.class, args);
    }

}
