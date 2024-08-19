package com.joey.loanservice.service;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.strategy.loanRequest.factory.LoanProcessFactory;
import io.spring.guides.loanservice.loan.LoanRequest;
import io.spring.guides.loanservice.loan.LoanResponse;
import io.spring.guides.loanservice.user.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final UserService userService;
    private final LoanProcessFactory loanProcessFactory;
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public LoanService (LoanProcessFactory loanProcessFactory, UserService userService) {
        this.loanProcessFactory = loanProcessFactory;
        this.userService = userService;
    }

    public LoanResponse requestLoan(LoanRequest request) throws Exception {
        UserType user = this.userService.getUserByDocument(request.getDocument());
        String destination = request.getDestination();

        LOGGER.info("[:] Loan requested by: {}, to: {}", user.getName(), destination);
        CustomLoanResponse loanResponse = this.loanProcessFactory.getStrategy(destination).processLoanRequest(user);

        LOGGER.info("[:] Loan result by: {}", loanResponse.getStatus());
        return loanResponse;
    }
}
