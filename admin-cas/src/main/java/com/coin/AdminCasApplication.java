package com.coin;

import org.apache.shiro.cas.CasFilter;
import org.jasig.cas.client.validation.Cas10TicketValidationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdminCasApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminCasApplication.class, args);
    }

}
