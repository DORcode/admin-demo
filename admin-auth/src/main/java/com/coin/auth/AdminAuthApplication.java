package com.coin.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
// @EnableSwagger2
@ComponentScan(basePackages = {"com.coin.base", "com.coin.auth"})
@MapperScan("com.coin.auth.web.mapper")
public class AdminAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminAuthApplication.class, args);
    }

}
