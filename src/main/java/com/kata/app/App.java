package com.kata.app;

import com.kata.app.utils.SystemIOWrapper;

public class App 
{
    public static void main(String[] args)
    {
        UserInterface userInterface = new UserInterface(new StringCalculator(), new SystemIOWrapper());
        userInterface.startCalculator();
    }
}
