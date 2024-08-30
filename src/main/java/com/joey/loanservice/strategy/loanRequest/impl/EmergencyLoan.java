package com.joey.loanservice.strategy.loanRequest.impl;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.model.UserModel;
import com.joey.loanservice.strategy.EmergencyLoan.factory.EmergencyLoanOptionsFactory;
import com.joey.loanservice.strategy.loanRequest.ILoanProcessStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmergencyLoan implements ILoanProcessStrategy {

    private EmergencyLoanOptionsFactory emergencyLoanOptionsFactory;

    @Override
    public CustomLoanResponse processLoanRequest(Long incomePerYear, Integer age) throws Exception {
        return this.emergencyLoanOptionsFactory.getStrategy(incomePerYear).processLoanOptions(age);
    }

    @Override
    public String getDestination() {
        return "EMERGENCY";
    }
}
