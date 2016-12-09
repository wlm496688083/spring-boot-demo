package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class DefaultConfiguration {
    @Configuration
    @Profile("prod")
    @PropertySource(value = {"classpath:important.properties"},
            ignoreResourceNotFound = true)
    static class Production {
    }


    @Configuration
    @Profile("dev")
    @PropertySource(value = {"classpath:dev.properties"},
            ignoreResourceNotFound = true)
    static class Development {
    }
}



