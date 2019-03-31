package com.lodqa.calculator;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${container.url}")
    private String containerWsUrl;

    public String getContainerWsUrl() {
        return containerWsUrl;
    }
}
