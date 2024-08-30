package com.joey.loanservice.strategy.EmergencyLoan.impl;

import io.spring.guides.loanservice.loan.LoanType;

import java.util.List;

public interface IEmergencyLoanAgeStrategy {

    List<LoanType> processLoanOptions ();
    Integer getAgeRole ();
}
