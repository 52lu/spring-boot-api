package com.hui.springbootapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hui.springbootapi.model.dao")
public class SpringBootApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApiApplication.class, args);
    }

}
