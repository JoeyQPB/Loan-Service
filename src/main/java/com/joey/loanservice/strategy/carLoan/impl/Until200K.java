package com.joey.loanservice.strategy.carLoan.impl;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.model.UserModel;
import com.joey.loanservice.strategy.carLoan.ICarLoanStrategy;
import io.spring.guides.loanservice.loan.LoanType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Until200K implements ICarLoanStrategy {

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
            loanBasic.setValue(100000);

            loanIntermediate.setInstallments(24);
            loanIntermediate.setInterest(2.5);
            loanIntermediate.setValue(240000);

            loanAdvanced.setInstallments(36);
            loanAdvanced.setInterest(5);
            loanAdvanced.setValue(360000);

        } else if (age < 45) {
            loanBasic.setInstallments(12);
            loanBasic.setInterest(1);
            loanBasic.setValue(150000);

            loanIntermediate.setInstallments(24);
            loanIntermediate.setInterest(2.5);
            loanIntermediate.setValue(290000);

            loanAdvanced.setInstallments(36);
            loanAdvanced.setInterest(5);
            loanAdvanced.setValue(400000);

        } else {
            loanBasic.setInstallments(12);
            loanBasic.setInterest(1);
            loanBasic.setValue(170000);

            loanIntermediate.setInstallments(24);
            loanIntermediate.setInterest(2.5);
            loanIntermediate.setValue(310000);

            loanAdvanced.setInstallments(36);
            loanAdvanced.setInterest(5);
            loanAdvanced.setValue(440000);
        }

        return new ArrayList<>(List.of(loanBasic, loanIntermediate, loanAdvanced));
    }
}