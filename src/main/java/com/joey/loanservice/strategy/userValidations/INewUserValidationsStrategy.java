package com.joey.loanservice.strategy.userValidations;

import io.spring.guides.loanservice.user.UserInfo;

public interface INewUserValidationsStrategy {

    void execute (UserInfo data);
}
