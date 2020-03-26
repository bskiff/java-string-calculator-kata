package com.kata.app;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

import com.kata.app.utils.SystemIOWrapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserInterfaceTest {
    @Mock
    private StringCalculator stringCalculator;

    @Mock
    private SystemIOWrapper systemIOWrapper;

    @InjectMocks
    private UserInterface userInterface;
    
    private String expectedInput;
    private BigDecimal expectedResult;

    @Before
    public void setup() {
        expectedInput = UUID.randomUUID().toString();
        expectedResult = BigDecimal.valueOf(new Random().nextInt());
        doReturn(expectedInput).when(systemIOWrapper).nextLine();
        doReturn(expectedResult).when(stringCalculator).add(anyString());
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        userInterface.startCalculator();

        verify(systemIOWrapper).println("Welcome to the String Calculator!");
    }

    @Test
    public void shouldPromptUserAndCallGetNextLine() {
        userInterface.startCalculator();

        verify(systemIOWrapper).println("Enter arguments to add:");
        verify(systemIOWrapper).nextLine();
    }

    @Test
    public void shouldCallStringCalculatorAddWithNextLine() {
        userInterface.startCalculator();

        verify(stringCalculator).add(expectedInput);
    }

    @Test
    public void shouldPrintResultFromAdd() {
        userInterface.startCalculator();

        verify(systemIOWrapper).println("Result: " + expectedResult);
    }
}