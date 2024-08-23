package com.joey.loanservice.strategy.DefaultRefusalValidations.impl;

import com.joey.loanservice.exceptions.LoanRefusalException;
import com.joey.loanservice.strategy.DefaultRefusalValidations.IDefaultRefusalValidations;

public class age46to89Validation implements IDefaultRefusalValidations {

    @Override
    public void execute(Long incomePerYear, Integer age) {


        if ((age >= 46 && age <= 89) && incomePerYear < 35000) {
            throw new LoanRefusalException("With age: " + age + " - you must have a 35k incomePerYear!" );
        }
    }
}
