package com.joey.loanservice.exceptions;

public class LoanRefusalException extends RuntimeException {

    public LoanRefusalException(String msg) {
        super(msg);
    }
}
