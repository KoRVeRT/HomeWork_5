package ru.dataart.academy.java;

import java.io.File;


public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String zipPath = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.zip";
        String zip1Path = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test1.zip";
        System.out.println("Calculator get number of 1: " + calculator.getNumberOfChar(zipPath, '1'));
        System.out.println("Calculator get number of 3: " + calculator.getNumberOfChar(zipPath, '3'));

        System.out.println("Calculator get max length: " + calculator.getMaxWordLength(zip1Path));
    }
}