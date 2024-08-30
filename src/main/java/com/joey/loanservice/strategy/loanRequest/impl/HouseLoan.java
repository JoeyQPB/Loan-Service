package com.joey.loanservice.strategy.loanRequest.impl;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.strategy.loanRequest.ILoanProcessStrategy;
import com.joey.loanservice.strategy.loanRequest.impl.factory.LoanOptionFactory;
import io.spring.guides.loanservice.loan.LoanType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HouseLoan implements ILoanProcessStrategy {

    private LoanType loanBasic = null;
    private LoanType loanIntermediate = null;
    private LoanType loanAdvanced = null;

    private final Map<Double, LoanType> loanDataOptions = new HashMap<>() {{
        put(1.0, LoanOptionFactory.build(24, 1.8, 150000));
        put(1.1, LoanOptionFactory.build(36, 2.0, 200000));
        put(1.2, LoanOptionFactory.build(48, 2.5, 250000));
        put(2.0, LoanOptionFactory.build(24, 1.8, 250000));
        put(2.1, LoanOptionFactory.build(36, 2.0, 300000));
        put(2.2, LoanOptionFactory.build(48, 2.5, 350000));
        put(3.0, LoanOptionFactory.build(24, 1.8, 350000));
        put(3.1, LoanOptionFactory.build(36, 2.0, 400000));
        put(3.2, LoanOptionFactory.build(48, 2.5, 450000));
    }};

    @Override
    public CustomLoanResponse processLoanRequest(Long incomePerYear, Integer age) throws Exception {
        Double roleFactor = this.calculateRole(incomePerYear, age);

        this.loanBasic = loanDataOptions.get(roleFactor);
        this.loanIntermediate = loanDataOptions.get(roleFactor+0.1);
        this.loanAdvanced = loanDataOptions.get(roleFactor+0.2);

        CustomLoanResponse customLoanResponse = new CustomLoanResponse();
        customLoanResponse.setLoanData(List.of(this.loanBasic, this.loanIntermediate, this.loanAdvanced));
        customLoanResponse.setStatus(this.getStatus());
        return customLoanResponse;
    }

    @Override
    public String getDestination() {
        return "HOUSE";
    }

    private Double calculateRole(Long incomePerYear, Integer age) {
        double roleFactor;
        if (incomePerYear < 100000) {
            roleFactor = 1.0;
        } else if (incomePerYear < 200000) {
            roleFactor = 2.0;
        } else {
            roleFactor = 3.0;
        }
        return roleFactor;
    }

    private String getStatus() {
        double scale = Math.pow(10, 2);

        StringBuilder sb = new StringBuilder();
        sb.append("APPROVED\n\n");

        double totalBasic = (loanBasic.getValue() + ((loanBasic.getInterest()/100) * loanBasic.getValue()));
        double installmentBasicValue = Math.ceil((totalBasic/ loanBasic.getInstallments()) * scale) / scale;
        sb.append("BASIC LOAN: \n");
        sb.append("TOTAL PAYMENT: ").append(totalBasic);
        sb.append("INSTALLMENT VALUE: : ").append(installmentBasicValue);
        sb.append("\n\n");

        double totalIntermediate = (loanIntermediate.getValue() + ((loanIntermediate.getInterest()/100) * loanIntermediate.getValue()));
        double installmentIntermediateValue = Math.ceil((totalBasic/ loanIntermediate.getInstallments()) * scale) / scale;;
        sb.append("INTERMEDIATE LOAN: \n");
        sb.append("TOTAL PAYMENT: ").append(totalIntermediate);
        sb.append("INSTALLMENT VALUE: : ").append(installmentIntermediateValue);
        sb.append("\n\n");

        double totalAdvanced = (loanAdvanced.getValue() + ((loanAdvanced.getInterest()/100) * loanAdvanced.getValue()));
        double installmentBasicAdvanced = Math.ceil((totalBasic/ loanAdvanced.getInstallments()) * scale) / scale;
        sb.append("ADVANCED LOAN: \n");
        sb.append("TOTAL PAYMENT: ").append(totalAdvanced);
        sb.append("INSTALLMENT VALUE: : ").append(installmentBasicAdvanced);
        sb.append("\n\n");
        return sb.toString();
    }
}
