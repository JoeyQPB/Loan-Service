package com.joey.loanservice.strategy.TravelLoan;

import com.joey.loanservice.strategy.ILoanDefaultStrategy;

public interface ITravelLoanStrategy extends ILoanDefaultStrategy {

    @Override
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

        return sb.toString();
    }
}
