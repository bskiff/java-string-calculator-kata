package com.kata.app;

import java.math.BigDecimal;

import com.kata.app.utils.SystemIOWrapper;

class UserInterface {
    private StringCalculator stringCalculator;
    private SystemIOWrapper systemIOWrapper;

    public UserInterface(
        StringCalculator stringCalculator,
        SystemIOWrapper systemIOWrapper
    ) {
        this.stringCalculator = stringCalculator;
        this.systemIOWrapper = systemIOWrapper;
    }

    public void startCalculator() {
        systemIOWrapper.println("Welcome to the String Calculator!");
        systemIOWrapper.println("Enter arguments to add:");
        String nextLine = systemIOWrapper.nextLine();
        BigDecimal result = stringCalculator.add(nextLine);
        systemIOWrapper.println("Result: " + result.toString());
    }
}