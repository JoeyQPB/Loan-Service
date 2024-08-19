package com.joey.loanservice.strategy.userValidations.impl;

import com.joey.loanservice.strategy.userValidations.INewUserValidationsStrategy;
import io.spring.guides.loanservice.user.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class IncomePerYearValidation implements INewUserValidationsStrategy {

    @Override
    public void execute(UserInfo data) {
//        System.out.println("Executing IncomePerYearValidation!");

        if (data.getIncomePerYear() < 12000L) {
            throw new IllegalArgumentException("Income Per Year must be over 11.999k");
        }
    }
}
