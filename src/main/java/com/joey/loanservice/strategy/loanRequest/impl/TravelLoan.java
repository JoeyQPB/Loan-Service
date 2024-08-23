package com.joey.loanservice.strategy.loanRequest.impl;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.model.UserModel;
import com.joey.loanservice.strategy.loanRequest.ILoanProcessStrategy;
import io.spring.guides.loanservice.user.UserType;
import org.springframework.stereotype.Service;

@Service
public class TravelLoan implements ILoanProcessStrategy {

    @Override
    public CustomLoanResponse processLoanRequest(UserModel user) {
        return null;
    }

    @Override
    public String getDestination() {
        return "TRAVEL";
    }
}
