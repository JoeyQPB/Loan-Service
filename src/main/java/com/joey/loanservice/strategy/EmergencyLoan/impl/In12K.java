package com.joey.loanservice.strategy.EmergencyLoan.impl;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.strategy.EmergencyLoan.IEmergencyLoanIncomeStrategy;
import com.joey.loanservice.strategy.EmergencyLoan.impl.factory.EmergencyLoanAgeOptionsFactory;
import io.spring.guides.loanservice.loan.LoanType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class In12K implements IEmergencyLoanIncomeStrategy {

    private final EmergencyLoanAgeOptionsFactory emergencyLoanAgeOptionsFactory;

    public In12K(EmergencyLoanAgeOptionsFactory emergencyLoanAgeOptionsFactory) {
        this.emergencyLoanAgeOptionsFactory = emergencyLoanAgeOptionsFactory;
    }

    @Override
    public CustomLoanResponse processLoanOptions(Integer age) {
        List<LoanType> loanTypes = emergencyLoanAgeOptionsFactory.getStrategy(age).processLoanOptions(1);
        CustomLoanResponse customLoanResponse = new CustomLoanResponse();
        customLoanResponse.setLoanData(loanTypes);
        this.setLoans(loanTypes);
        customLoanResponse.setStatus(this.getStatus());
        return customLoanResponse;
    }

    @Override
    public Integer getIncomePerYearRole() {
        return 0;
    }
}
