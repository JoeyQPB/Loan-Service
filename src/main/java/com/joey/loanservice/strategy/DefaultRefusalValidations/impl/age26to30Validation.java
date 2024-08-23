package com.joey.loanservice.strategy.DefaultRefusalValidations.impl;

import com.joey.loanservice.exceptions.LoanRefusalException;
import com.joey.loanservice.strategy.DefaultRefusalValidations.IDefaultRefusalValidations;

public class age26to30Validation implements IDefaultRefusalValidations {

    @Override
    public void execute(Long incomePerYear, Integer age) {

        if ((age >= 26 && age <= 30) && incomePerYear < 20000) {
            throw new LoanRefusalException("With age: " + age + " - you must have a 20k incomePerYear!" );
        }
    }
}
