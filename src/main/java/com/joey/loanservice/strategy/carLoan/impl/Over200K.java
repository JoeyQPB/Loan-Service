package com.joey.loanservice.strategy.carLoan.impl;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.strategy.carLoan.ICarLoanStrategy;
import io.spring.guides.loanservice.loan.LoanType;

import java.util.ArrayList;
import java.util.List;

public class Over200K implements ICarLoanStrategy {

    @Override
    public CustomLoanResponse processLoanOptions(Integer age) {
        CustomLoanResponse customLoanResponse = new CustomLoanResponse();
        customLoanResponse.setStatus(this.getStatus());
        customLoanResponse.setLoanData(this.getLoanOptions(age));
        return customLoanResponse;
    }

    @Override
    public Integer getIncomePerYearRole() {
        return 2;
    }

    private List<LoanType> getLoanOptions(Integer age) {
        if (age < 35) {
            loanBasic.setInstallments(12);
            loanBasic.setInterest(1);
            loanBasic.setValue(150000);

            loanIntermediate.setInstallments(24);
            loanIntermediate.setInterest(2.5);
            loanIntermediate.setValue(290000);

            loanAdvanced.setInstallments(36);
            loanAdvanced.setInterest(5);
            loanAdvanced.setValue(390000);

        } else if (age < 45) {
            loanBasic.setInstallments(12);
            loanBasic.setInterest(1);
            loanBasic.setValue(180000);

            loanIntermediate.setInstallments(24);
            loanIntermediate.setInterest(2.5);
            loanIntermediate.setValue(370000);

            loanAdvanced.setInstallments(36);
            loanAdvanced.setInterest(5);
            loanAdvanced.setValue(440000);

        } else {
            loanBasic.setInstallments(12);
            loanBasic.setInterest(1);
            loanBasic.setValue(200000);

            loanIntermediate.setInstallments(24);
            loanIntermediate.setInterest(2.5);
            loanIntermediate.setValue(400000);

            loanAdvanced.setInstallments(36);
            loanAdvanced.setInterest(5);
            loanAdvanced.setValue(500000);
        }

        return new ArrayList<>(List.of(loanBasic, loanIntermediate, loanAdvanced));
    }

}
