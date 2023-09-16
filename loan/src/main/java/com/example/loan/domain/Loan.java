package com.example.loan.domain;

public class Loan {
    Long loanAmount;
    Integer installment;
    Long installmentAmount;

    public Loan(Long loanAmount, Integer installment, Long installmentAmount) {
        this.loanAmount = loanAmount;
        this.installment = installment;
        this.installmentAmount = installmentAmount;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    public Long getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(Long installmentAmount) {
        this.installmentAmount = installmentAmount;
    }
}
