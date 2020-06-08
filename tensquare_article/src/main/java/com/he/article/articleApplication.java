package com.he.article;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.he.article.dao")
public class articleApplication {

    public static void main(String[] args) {
        SpringApplication.run(articleApplication.class,args);
    }
}
