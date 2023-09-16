package com.example.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RefreshScope
@RestController("/")
public class AccountApplication {

    private final ServiceConfig serviceConfig;

    @Value("${tracer.property}")
    private String message;

    public AccountApplication(ServiceConfig serviceConfig) {
        this.serviceConfig = serviceConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    @GetMapping("message")
    public String message(){
        return serviceConfig.getProperty();
    }

}
