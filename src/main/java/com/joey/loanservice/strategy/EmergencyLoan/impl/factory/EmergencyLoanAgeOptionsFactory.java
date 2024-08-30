package com.joey.loanservice.strategy.EmergencyLoan.impl.factory;

import com.joey.loanservice.strategy.EmergencyLoan.impl.IEmergencyLoanAgeStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class EmergencyLoanAgeOptionsFactory {

    private final Map<Integer, IEmergencyLoanAgeStrategy> strategies = new HashMap<>();

    public EmergencyLoanAgeOptionsFactory(Set<IEmergencyLoanAgeStrategy> strategySet) {
        strategySet.forEach(s -> strategies.put(s.getAgeRole(), s));
    }

    public IEmergencyLoanAgeStrategy getStrategy (int age) {
        Integer incomePerYearRole = null;

        if (age > 21 && age <= 25) {
            incomePerYearRole =  0;
        } else if (age > 25 && age <= 45) {
            incomePerYearRole =  1;
        } else {
            incomePerYearRole =  2;
        }

        IEmergencyLoanAgeStrategy strategy = strategies.get(incomePerYearRole);

        if (strategy == null) {
            System.out.println("Not Options Loans for Emergency with age: " + age);
        }

        return strategy;
    }
}
