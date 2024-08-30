package com.joey.loanservice.strategy.EmergencyLoan.impl.impl;

import com.joey.loanservice.strategy.EmergencyLoan.impl.IEmergencyLoanAgeStrategy;
import com.joey.loanservice.strategy.loanRequest.impl.factory.LoanOptionFactory;
import io.spring.guides.loanservice.loan.LoanType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AgeRange46to99 implements IEmergencyLoanAgeStrategy {
    @Override
    public List<LoanType> processLoanOptions(int incomeFactor) {
        List<LoanType> loanTypes = new ArrayList<>();
        loanTypes.add(LoanOptionFactory.build(12, 2.5, 60000 * incomeFactor));
        loanTypes.add(LoanOptionFactory.build(18, 3.5, 80000 * incomeFactor));
        loanTypes.add(LoanOptionFactory.build(24, 4.0, 100000 * incomeFactor));
        return loanTypes;
    }

    @Override
    public Integer getAgeRole() {
        return 2;
    }
}
