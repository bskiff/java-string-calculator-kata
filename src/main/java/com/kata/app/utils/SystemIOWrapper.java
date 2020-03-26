package com.kata.app.utils;

import java.util.Scanner;

public class SystemIOWrapper {
    public String nextLine() {
        final Scanner scanner = new Scanner(System.in);
        final String nextLine = scanner.nextLine();
        scanner.close();
        return nextLine;
    }

    public void println(final String string) {
        System.out.println(string);
    }
}