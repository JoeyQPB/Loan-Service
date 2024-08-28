package com.joey.loanservice.strategy.loanRequest.impl;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.model.UserModel;
import com.joey.loanservice.strategy.loanRequest.ILoanProcessStrategy;
import org.springframework.stereotype.Service;

@Service
public class TravelLoan implements ILoanProcessStrategy {

    // TODO
    // DATA INCOMEPERYEAR AND AGE
    // BUILD RESPONSE

    @Override
    public CustomLoanResponse processLoanRequest(Long incomePerYear, Integer age) throws Exception {
        return null;
    }

    @Override
    public String getDestination() {
        return "TRAVEL";
    }
}
