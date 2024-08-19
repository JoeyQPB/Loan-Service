package com.joey.loanservice.endpoint;

import com.joey.loanservice.dtos.CustomLoanResponse;
import com.joey.loanservice.service.LoanService;
import io.spring.guides.loanservice.loan.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class LoanEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/loanservice/loan";

    @Autowired
    private LoanService loanService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LoanRequest")
    @ResponsePayload
    public LoanResponse requestForLoan (@RequestPayload LoanRequest request) throws Exception {
        return this.loanService.requestLoan(request);
    }
}
