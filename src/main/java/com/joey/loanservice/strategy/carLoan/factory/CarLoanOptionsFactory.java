package com.joey.loanservice.strategy.carLoan.factory;

import com.joey.loanservice.model.UserModel;
import com.joey.loanservice.strategy.carLoan.ICarLoanStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class CarLoanOptionsFactory {

    private final Map<Integer, ICarLoanStrategy> strategies = new HashMap<>();

    public CarLoanOptionsFactory(Set<ICarLoanStrategy> strategySet) {
        strategySet.forEach(s -> strategies.put(s.getIncomePerYearRole(), s));
    }

    public ICarLoanStrategy getStrategy (Long incomePerYear) throws Exception {
        Integer incomePerYearRole = null;

        if (incomePerYear <= 100000) {
            incomePerYearRole =  0;
        } else if (incomePerYear <= 200000) {
            incomePerYearRole =  1;
        } else if (incomePerYear > 200000) {
            incomePerYearRole =  2;
        } else {
            throw new IllegalArgumentException("Invalid income value");
        }

        ICarLoanStrategy strategy = strategies.get(incomePerYearRole);

        if (strategy == null) {
            System.out.println("Not Options Loans for income: " + incomePerYear);
            throw new Exception("Not Options Loans for income: " + incomePerYear);
        }

        return strategy;
    }
}
