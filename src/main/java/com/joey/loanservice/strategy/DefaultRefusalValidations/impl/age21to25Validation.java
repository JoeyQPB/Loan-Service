package com.joey.loanservice.strategy.DefaultRefusalValidations.impl;

import com.joey.loanservice.exceptions.LoanRefusalException;
import com.joey.loanservice.strategy.DefaultRefusalValidations.IDefaultRefusalValidations;

public class age21to25Validation implements IDefaultRefusalValidations {

    @Override
    public void execute(Long incomePerYear, Integer age) {

        if ((age >= 21 && age <= 25) && incomePerYear < 18000) {
            throw new LoanRefusalException("With age: " + age + " - you must have a 18k incomePerYear!" );
        }
    }
}
