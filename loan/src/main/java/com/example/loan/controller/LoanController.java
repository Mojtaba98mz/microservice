package com.example.loan.controller;

import com.example.loan.domain.Loan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class LoanController {
    @GetMapping("/loan")
    public List<Loan> getAccountLoans(){
        List<Loan> loans = new ArrayList<>();
        loans.add(new Loan(5000000L,12,500000L));
        return loans;
    }
}
