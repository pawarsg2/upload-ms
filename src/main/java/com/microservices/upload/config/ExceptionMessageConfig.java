package com.microservices.upload.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "data.exception")
@Data
public class ExceptionMessageConfig {
	
	
    private String message1;
    private String message2;
    private String message3;

}
