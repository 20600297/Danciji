package com.xiqi.wzq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DanciJiApplication {
    public static void main(String[] args) {
        SpringApplication.run(DanciJiApplication.class, args);
    }
}
