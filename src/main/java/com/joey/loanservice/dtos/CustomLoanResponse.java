package com.joey.loanservice.dtos;

import io.spring.guides.loanservice.loan.LoanResponse;
import io.spring.guides.loanservice.loan.LoanType;

import java.util.List;

public class CustomLoanResponse extends LoanResponse {

    public void setLoanData(List<LoanType> loanData) {
        this.loanData = loanData;
    }
}
