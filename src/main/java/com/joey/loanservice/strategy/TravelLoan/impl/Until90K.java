package com.joey.loanservice.strategy.TravelLoan.impl;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.strategy.TravelLoan.ITravelLoanStrategy;
import io.spring.guides.loanservice.loan.LoanType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Until90K implements ITravelLoanStrategy {

    @Override
    public CustomLoanResponse processLoanOptions(Integer age) {
        CustomLoanResponse customLoanResponse = new CustomLoanResponse();
        customLoanResponse.setLoanData(this.getLoanOptions(age));
        customLoanResponse.setStatus(this.getStatus());
        return customLoanResponse;
    }

    @Override
    public Integer getIncomePerYearRole() {
        return 1;
    }

    private List<LoanType> getLoanOptions(Integer age) {
        if (age < 35) {
            loanBasic.setInstallments(12);
            loanBasic.setInterest(1);
            loanBasic.setValue(70000);

            loanIntermediate.setInstallments(24);
            loanIntermediate.setInterest(2.5);
            loanIntermediate.setValue(100000);

        } else if (age < 45) {
            loanBasic.setInstallments(12);
            loanBasic.setInterest(1);
            loanBasic.setValue(90000);

            loanIntermediate.setInstallments(24);
            loanIntermediate.setInterest(2.5);
            loanIntermediate.setValue(120000);

        } else {
            loanBasic.setInstallments(12);
            loanBasic.setInterest(1);
            loanBasic.setValue(120000);

            loanIntermediate.setInstallments(24);
            loanIntermediate.setInterest(2.5);
            loanIntermediate.setValue(200000);
        }

        return new ArrayList<>(List.of(loanBasic, loanIntermediate));
    }
}
