package com.joey.loanservice.strategy.loanRequest.impl;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.strategy.loanRequest.ILoanProcessStrategy;
import com.joey.loanservice.strategy.loanRequest.utils.DefaultRefusal;
import io.spring.guides.loanservice.user.UserType;
import org.springframework.stereotype.Service;

@Service
public class CarLoan implements ILoanProcessStrategy {

    @Override
    public CustomLoanResponse processLoanRequest(UserType userType) {
        CustomLoanResponse customLoanResponse = new CustomLoanResponse();

        DefaultRefusal.DefaultRefusalResponse defResp = DefaultRefusal.isBasicallyAcceptable(userType);

        if (Boolean.FALSE.equals(defResp.status())) {
             customLoanResponse.setStatus("Refuse by: " + defResp.reason());
             customLoanResponse.setLoanData(null);
            return customLoanResponse;
        }

        return null;
    }

    @Override
    public String getDestination() {
        return "CAR";
    }
}
