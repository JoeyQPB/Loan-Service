package com.joey.loanservice.strategy.loanRequest.utils;

import io.spring.guides.loanservice.user.UserType;

public class DefaultRefusal {

    public record DefaultRefusalResponse (Boolean status, String reason) {}

    public static DefaultRefusalResponse isBasicallyAcceptable (UserType user) {
        // TODO strategy
        // under 21
        // over 90
        // 21 to 25 and income under 18k
        // 25 to 30 and income under 20k
        // 30 to 45 and income under 25k
        // 45 to 90 and income under 35k
        return null;
    }

}
