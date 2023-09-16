package com.example.account;

import com.example.account.domain.Loan;
import com.example.account.service.LoanFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RefreshScope
@EnableFeignClients
@EnableDiscoveryClient
@RestController("/")
public class AccountApplication {

    private final ServiceConfig serviceConfig;

    private final LoanFeignClient loanFeignClient;
    private final DiscoveryClient discoveryClient;

    @Value("${tracer.property}")
    private String message;

    public AccountApplication(ServiceConfig serviceConfig, LoanFeignClient loanFeignClient, DiscoveryClient discoveryClient) {
        this.serviceConfig = serviceConfig;
        this.loanFeignClient = loanFeignClient;
        this.discoveryClient = discoveryClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    @GetMapping("message")
    public String message(){
        return serviceConfig.getProperty();
    }

    @GetMapping("getByFeign")
    public List<Loan> getByFeign(){
        return loanFeignClient.getAccountLoan(1L);
    }

}
