package com.joey.loanservice.strategy.DefaultRefusalValidations.impl;

import com.joey.loanservice.exceptions.LoanRefusalException;
import com.joey.loanservice.strategy.DefaultRefusalValidations.IDefaultRefusalValidations;

public class outAgeValidation implements IDefaultRefusalValidations {

    @Override
    public void execute(Long incomePerYear, Integer age) {
        if (age > 89 || age < 21) {
            throw new LoanRefusalException("Your age: " + age + "is out of our work age!" );
        }
    }
}
