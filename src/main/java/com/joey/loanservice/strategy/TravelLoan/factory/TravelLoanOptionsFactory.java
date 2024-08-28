package com.joey.loanservice.strategy.TravelLoan.factory;

import com.joey.loanservice.strategy.TravelLoan.ITravelLoanStrategy;
import com.joey.loanservice.strategy.carLoan.ICarLoanStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TravelLoanOptionsFactory {

    private final Map<Integer, ITravelLoanStrategy> strategies = new HashMap<>();

    public TravelLoanOptionsFactory(Set<ITravelLoanStrategy> strategySet) {
        strategySet.forEach(s -> strategies.put(s.getIncomePerYearRole(), s));
    }

    public ITravelLoanStrategy getStrategy(Long incomePerYear) throws Exception {
        Integer incomePerYearRole = null;

        if (incomePerYear <= 60000) {
            incomePerYearRole =  0;
        } else if (incomePerYear <= 90000) {
            incomePerYearRole =  1;
        } else {
            incomePerYearRole =  2;
        }

        ITravelLoanStrategy strategy = strategies.get(incomePerYearRole);

        if (strategy == null) {
            System.out.println("Not Options Loans for travel with income: " + incomePerYear);
            throw new Exception("Not Options Loans for travel with income: " + incomePerYear);
        }

        return strategy;
    }

}
