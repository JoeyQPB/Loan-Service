package com.joey.loanservice.strategy.EmergencyLoan.impl.impl;

import com.joey.loanservice.strategy.EmergencyLoan.impl.IEmergencyLoanAgeStrategy;
import com.joey.loanservice.strategy.loanRequest.impl.factory.LoanOptionFactory;
import io.spring.guides.loanservice.loan.LoanType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AgeRange21to25 implements IEmergencyLoanAgeStrategy {

    @Override
    public List<LoanType> processLoanOptions() {
        List<LoanType> loanTypes = new ArrayList<>();
        loanTypes.add(LoanOptionFactory.build(12, 2.5, 20000));
        loanTypes.add(LoanOptionFactory.build(18, 3.5, 40000));
        loanTypes.add(LoanOptionFactory.build(24, 4.0, 60000));
        return loanTypes;
    }

    @Override
    public Integer getAgeRole() {
        return 0;
    }
}
