package com.joey.loanservice.service;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.model.UserModel;
import com.joey.loanservice.strategy.DefaultRefusalValidations.IDefaultRefusalValidations;
import com.joey.loanservice.strategy.loanRequest.factory.LoanProcessFactory;
import io.spring.guides.loanservice.loan.LoanRequest;
import io.spring.guides.loanservice.loan.LoanResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class LoanService {

    private final UserService userService;
    private final LoanProcessFactory loanProcessFactory;
    private final List<IDefaultRefusalValidations> defaultRefusalValidationsList;
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public LoanService (LoanProcessFactory loanProcessFactory,
                        UserService userService,
                        List<IDefaultRefusalValidations> defaultRefusalValidationsList) {
        this.loanProcessFactory = loanProcessFactory;
        this.userService = userService;
        this.defaultRefusalValidationsList = defaultRefusalValidationsList;
    }

    public LoanResponse requestLoan(LoanRequest request) throws Exception {

        UserModel user = this.userService.getUserByModelDocument(request.getDocument());
        String destination = request.getDestination();
        CustomLoanResponse loanResponse = new CustomLoanResponse();
        LOGGER.info("[:] Loan requested by: {}, to: {}", user.getName(), destination);

        Long incomePerYear = user.getIncomePerYear();
        int actualAge = Period.between(user.getDateOfBirth(), LocalDate.now()).getYears();
        System.out.println("A idade atual é: " + actualAge);

        defaultRefusalValidationsList.forEach(defaultRef -> defaultRef.execute(incomePerYear, actualAge));
        System.out.println("TODAS AS VALIDAÇÕES FORAM FEITAS!");

        loanResponse = this.loanProcessFactory.getStrategy(destination).
                processLoanRequest(user.getIncomePerYear(), actualAge);

        LOGGER.info("[:] Loan result by: {}", loanResponse.getStatus());
        return loanResponse;
    }
}
