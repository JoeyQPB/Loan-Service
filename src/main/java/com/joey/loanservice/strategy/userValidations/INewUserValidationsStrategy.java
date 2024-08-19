package com.joey.loanservice.strategy.userValidations;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.spring.guides.loanservice.user.UserInfo;

public interface INewUserValidationsStrategy {

    void execute (UserInfo data);
}
