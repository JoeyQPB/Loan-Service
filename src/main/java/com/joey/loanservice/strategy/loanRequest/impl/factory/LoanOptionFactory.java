package com.joey.loanservice.strategy.loanRequest.impl.factory;

import io.spring.guides.loanservice.loan.LoanType;
import org.springframework.stereotype.Component;

@Component
public class LoanOptionFactory {

    public static LoanType build (int installments, double interest, int value) {
        LoanType loanType = new LoanType();
        loanType.setInstallments(installments);
        loanType.setInterest(interest);
        loanType.setValue(value);
        return loanType;
    }

}
