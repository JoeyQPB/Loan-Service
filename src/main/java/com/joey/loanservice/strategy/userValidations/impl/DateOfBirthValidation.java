package com.joey.loanservice.strategy.userValidations.impl;

import com.joey.loanservice.strategy.userValidations.INewUserValidationsStrategy;
import io.spring.guides.loanservice.user.UserInfo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class DateOfBirthValidation implements INewUserValidationsStrategy {

    @Override
    public void execute(UserInfo data) {
//        System.out.println("Executing DateOfBirthValidation!");
        String dateString = data.getDateOfBirth();

        if (dateString == null || dateString.trim().isEmpty()) {
            throw new IllegalArgumentException("Date of birth cannot be null or empty");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date;

        try {
            date = LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + dateString);
        }

        LocalDate now = LocalDate.now();
        LocalDate date16YearsBefore = now.minusYears(16);
        LocalDate date100YearsBefore = now.minusYears(100);

        if (date.isBefore(date100YearsBefore)) {
            throw new IllegalArgumentException("Age cannot be more than 100 years");
        }

        if (date.isAfter(date16YearsBefore)) {
            throw new IllegalArgumentException("Age must be at least 16 years");
        }
    }
}
