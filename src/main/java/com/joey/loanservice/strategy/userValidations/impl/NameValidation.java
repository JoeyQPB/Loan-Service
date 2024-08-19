package com.joey.loanservice.strategy.userValidations.impl;

import com.joey.loanservice.strategy.userValidations.INewUserValidationsStrategy;
import io.spring.guides.loanservice.user.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class NameValidation implements INewUserValidationsStrategy {

    @Override
    public void execute(UserInfo data) {
//        System.out.println("Executing NameValidation!");
        String dataName = data.getName();

        if (dataName == null || dataName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (dataName.split(" ").length < 2 ) {
            throw new IllegalArgumentException("Must be your full name");
        }
    }
}
