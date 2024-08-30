package com.joey.loanservice.strategy.EmergencyLoan.impl;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.strategy.EmergencyLoan.IEmergencyLoanIncomeStrategy;
import com.joey.loanservice.strategy.EmergencyLoan.impl.factory.EmergencyLoanAgeOptionsFactory;
import io.spring.guides.loanservice.loan.LoanType;

import java.util.List;

public class Until36K implements IEmergencyLoanIncomeStrategy {

    private EmergencyLoanAgeOptionsFactory emergencyLoanAgeOptionsFactory;

    @Override
    public CustomLoanResponse processLoanOptions(Integer age) {
        List<LoanType> loanTypes = emergencyLoanAgeOptionsFactory.getStrategy(age).processLoanOptions();
        CustomLoanResponse customLoanResponse = new CustomLoanResponse();
        customLoanResponse.setLoanData(loanTypes);
        this.setLoans(loanTypes);
        customLoanResponse.setStatus(this.getStatus());
        return customLoanResponse;
    }

    @Override
    public Integer getIncomePerYearRole() {
        return 1;
    }
}
