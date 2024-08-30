package com.joey.loanservice.strategy;

import com.joey.loanservice.dtos.CustomLoanResponse;
import io.spring.guides.loanservice.loan.LoanType;

public interface ILoanDefaultStrategy {
    LoanType loanBasic = new LoanType();
    LoanType loanIntermediate = new LoanType();
    LoanType loanAdvanced = new LoanType();

    CustomLoanResponse processLoanOptions (Integer age);
    Integer getIncomePerYearRole ();

    public default String getStatus() {
        double scale = Math.pow(10, 2);

        StringBuilder sb = new StringBuilder();
        sb.append("APPROVED\n");

        double totalBasic = (loanBasic.getValue() + ((loanBasic.getInterest()/100) * loanBasic.getValue()));
        double installmentBasicValue = Math.ceil((totalBasic/ loanBasic.getInstallments()) * scale) / scale;
        sb.append("BASIC LOAN: \n");
        sb.append("TOTAL PAYMENT: ").append(totalBasic).append("\n");
        sb.append("INSTALLMENT VALUE: ").append(installmentBasicValue).append("\n");

        double totalIntermediate = (loanIntermediate.getValue() + ((loanIntermediate.getInterest()/100) * loanIntermediate.getValue()));
        double installmentIntermediateValue = Math.ceil((totalBasic/ loanIntermediate.getInstallments()) * scale) / scale;;
        sb.append("INTERMEDIATE LOAN: \n");
        sb.append("TOTAL PAYMENT: ").append(totalIntermediate).append("\n");
        sb.append("INSTALLMENT VALUE: ").append(installmentIntermediateValue).append("\n");

        double totalAdvanced = (loanAdvanced.getValue() + ((loanAdvanced.getInterest()/100) * loanAdvanced.getValue()));
        double installmentBasicAdvanced = Math.ceil((totalBasic/ loanAdvanced.getInstallments()) * scale) / scale;
        sb.append("ADVANCED LOAN: \n");
        sb.append("TOTAL PAYMENT: ").append(totalAdvanced).append("\n");
        sb.append("INSTALLMENT VALUE: ").append(installmentBasicAdvanced).append("\n");;
        return sb.toString();
    }
}
