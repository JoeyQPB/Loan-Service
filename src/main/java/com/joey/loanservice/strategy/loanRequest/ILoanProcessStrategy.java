package com.joey.loanservice.strategy.loanRequest;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.model.UserModel;
import io.spring.guides.loanservice.user.UserType;

public interface ILoanProcessStrategy {

    CustomLoanResponse processLoanRequest (UserModel user);
    String getDestination ();

}
