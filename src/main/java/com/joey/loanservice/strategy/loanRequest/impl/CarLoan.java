package com.joey.loanservice.strategy.loanRequest.impl;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.strategy.carLoan.factory.CarLoanOptionsFactory;
import com.joey.loanservice.strategy.loanRequest.ILoanProcessStrategy;
import org.springframework.stereotype.Service;

@Service
public class CarLoan implements ILoanProcessStrategy {

    private final CarLoanOptionsFactory carLoanOptionsFactory;

    public CarLoan(CarLoanOptionsFactory carLoanOptionsFactory) {
        this.carLoanOptionsFactory = carLoanOptionsFactory;
    }

    @Override
    public CustomLoanResponse processLoanRequest (Long incomePerYear, Integer age) throws Exception {
        return carLoanOptionsFactory.getStrategy(incomePerYear).processLoanOptions(age);
    }

    @Override
    public String getDestination() {
        return "CAR";
    }
}
