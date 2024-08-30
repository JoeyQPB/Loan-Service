package com.joey.loanservice.strategy.loanRequest.impl;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.model.UserModel;
import com.joey.loanservice.strategy.loanRequest.ILoanProcessStrategy;
import org.springframework.stereotype.Service;

@Service
public class TravelLoan implements ILoanProcessStrategy {

    @Override
    public CustomLoanResponse processLoanRequest(Long incomePerYear, Integer age) throws Exception {
        CustomLoanResponse customLoanResponse = new CustomLoanResponse();
        customLoanResponse.setStatus("Service unavailable! We are working on it!");
        customLoanResponse.setLoanData(null);
        return customLoanResponse;
    }

    @Override
    public String getDestination() {
        return "TRAVEL";
    }
}
