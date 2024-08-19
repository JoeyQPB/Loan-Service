package com.joey.loanservice.strategy.loanRequest.impl;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.strategy.loanRequest.ILoanProcessStrategy;
import io.spring.guides.loanservice.user.UserType;
import org.springframework.stereotype.Service;

@Service
public class EmergencyLoan implements ILoanProcessStrategy {

    @Override
    public CustomLoanResponse processLoanRequest(UserType userType) {
        return null;
    }

    @Override
    public String getDestination() {
        return "EMERGENCY";
    }
}
