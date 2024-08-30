package com.joey.loanservice.strategy.EmergencyLoan.factory;

import com.joey.loanservice.strategy.EmergencyLoan.IEmergencyLoanIncomeStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class EmergencyLoanOptionsFactory {

    private final Map<Integer, IEmergencyLoanIncomeStrategy> strategies = new HashMap<>();

    public EmergencyLoanOptionsFactory(Set<IEmergencyLoanIncomeStrategy> strategySet) {
        strategySet.forEach(s -> strategies.put(s.getIncomePerYearRole(), s));
    }

    public IEmergencyLoanIncomeStrategy getStrategy (Long incomePerYear) throws Exception {
        Integer incomePerYearRole = null;

        if (incomePerYear <= 12000) {
            incomePerYearRole =  0;
        } else if (incomePerYear <= 36000) {
            incomePerYearRole =  1;
        } else {
            incomePerYearRole =  2;
        }

        IEmergencyLoanIncomeStrategy strategy = strategies.get(incomePerYearRole);

        if (strategy == null) {
            System.out.println("No Options Loans for Emergency with income: " + incomePerYear);
            throw new Exception("No Options Loans Emergency with income: " + incomePerYear);
        }

        return strategy;
    }

}
