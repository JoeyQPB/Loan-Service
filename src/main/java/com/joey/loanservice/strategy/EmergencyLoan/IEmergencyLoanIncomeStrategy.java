package com.joey.loanservice.strategy.EmergencyLoan;

import com.joey.loanservice.strategy.ILoanDefaultStrategy;
import io.spring.guides.loanservice.loan.LoanType;

import java.util.List;

public interface IEmergencyLoanIncomeStrategy extends ILoanDefaultStrategy {

    default void setLoans(List<LoanType> loans) {

        loanBasic.setInterest(loans.get(0).getInterest());
        loanBasic.setInstallments(loans.get(0).getInstallments());
        loanBasic.setValue(loans.get(0).getValue());

        loanIntermediate.setInterest(loans.get(1).getInterest());
        loanIntermediate.setInstallments(loans.get(1).getInstallments());
        loanIntermediate.setValue(loans.get(1).getValue());

        loanAdvanced.setInterest(loans.get(2).getInterest());
        loanAdvanced.setInstallments(loans.get(2).getInstallments());
        loanAdvanced.setValue(loans.get(2).getValue());
    }
}
