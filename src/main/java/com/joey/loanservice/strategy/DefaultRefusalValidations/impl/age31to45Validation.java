package com.joey.loanservice.strategy.DefaultRefusalValidations.impl;

import com.joey.loanservice.exceptions.LoanRefusalException;
import com.joey.loanservice.strategy.DefaultRefusalValidations.IDefaultRefusalValidations;

public class age31to45Validation implements IDefaultRefusalValidations {

    @Override
    public void execute(Long incomePerYear, Integer age) {

        if ((age >= 31 && age <= 45) && incomePerYear < 25000) {
            throw new LoanRefusalException("With age: " + age + " - you must have a 25k incomePerYear!" );
        }
    }
}
