package com.joey.loanservice.strategy.loanRequest.impl;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.model.UserModel;
import com.joey.loanservice.strategy.EmergencyLoan.factory.EmergencyLoanOptionsFactory;
import com.joey.loanservice.strategy.TravelLoan.factory.TravelLoanOptionsFactory;
import com.joey.loanservice.strategy.loanRequest.ILoanProcessStrategy;
import org.springframework.stereotype.Service;

@Service
public class TravelLoan implements ILoanProcessStrategy {

    private final TravelLoanOptionsFactory travelLoanOptionsFactory;

    public TravelLoan (TravelLoanOptionsFactory travelLoanOptionsFactory) {
        this.travelLoanOptionsFactory = travelLoanOptionsFactory;
    }

    @Override
    public CustomLoanResponse processLoanRequest(Long incomePerYear, Integer age) throws Exception {
        return this.travelLoanOptionsFactory.getStrategy(incomePerYear).processLoanOptions(age);
    }

    @Override
    public String getDestination() {
        return "TRAVEL";
    }
}
