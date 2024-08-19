package com.joey.loanservice.strategy.loanRequest.factory;

import com.joey.loanservice.strategy.loanRequest.ILoanProcessStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class LoanProcessFactory {

    private final Map<String, ILoanProcessStrategy> strategies = new HashMap<>();

    public LoanProcessFactory(Set<ILoanProcessStrategy> strategySet) {
        strategySet.forEach(s -> strategies.put(s.getDestination(), s));
    }

    public ILoanProcessStrategy getStrategy (String destination) throws Exception {
        ILoanProcessStrategy strategy = strategies.get(destination);

        if (strategy == null) {
            System.out.println("Not Found Loans for: " + destination);
            throw new Exception("Not Found Loans for: " + destination);
        }

        return strategy;
    }

}
