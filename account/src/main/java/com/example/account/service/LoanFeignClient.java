package com.example.account.service;

import com.example.account.domain.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("loan")
public interface LoanFeignClient {
    @GetMapping(value = "loan/{accountId}", consumes = "application/json")
    List<Loan> getAccountLoan(@PathVariable Long accountId);
}
