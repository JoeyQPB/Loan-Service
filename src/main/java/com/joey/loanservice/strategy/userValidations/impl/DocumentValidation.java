package com.joey.loanservice.strategy.userValidations.impl;

import com.joey.loanservice.strategy.userValidations.INewUserValidationsStrategy;
import io.spring.guides.loanservice.user.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class DocumentValidation implements INewUserValidationsStrategy {

    @Override
    public void execute(UserInfo data) {
//        System.out.println("Executing DocumentValidation!");
        String dataDocument = data.getDocument();

        if (dataDocument == null || dataDocument.trim().isEmpty()) {
            throw new IllegalArgumentException("Document cannot be null or empty");
        }
    }
}
