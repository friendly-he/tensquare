package com.he.article.config;

import com.he.Utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IdworkerAuto {

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
