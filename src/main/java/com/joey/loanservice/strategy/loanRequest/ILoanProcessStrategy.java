package com.joey.loanservice.strategy.loanRequest;

import com.joey.loanservice.dtos.CustomLoanResponse;
import io.spring.guides.loanservice.user.UserType;

public interface ILoanProcessStrategy {

    CustomLoanResponse processLoanRequest (UserType userType);
    String getDestination ();

}
