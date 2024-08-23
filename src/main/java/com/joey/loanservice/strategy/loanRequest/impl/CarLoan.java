package com.joey.loanservice.strategy.loanRequest.impl;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.model.UserModel;
import com.joey.loanservice.strategy.loanRequest.ILoanProcessStrategy;
import com.joey.loanservice.strategy.loanRequest.utils.DefaultRefusal;
import io.spring.guides.loanservice.user.UserType;
import org.springframework.stereotype.Service;

@Service
public class CarLoan implements ILoanProcessStrategy {

    @Override
    public CustomLoanResponse processLoanRequest(UserModel user) {
        CustomLoanResponse customLoanResponse = new CustomLoanResponse();



        return null;
    }

    @Override
    public String getDestination() {
        return "CAR";
    }
}
