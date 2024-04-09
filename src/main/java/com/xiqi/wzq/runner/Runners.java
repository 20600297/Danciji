package com.xiqi.wzq.runner;

import com.xiqi.wzq.data.WordDataSource;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Runners {

    @Bean
    public ApplicationRunner test() {
        return args -> {
            WordDataSource.init();
        };
    }

}
