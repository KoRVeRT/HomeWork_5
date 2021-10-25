package ru.dataart.academy.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipInputStream;

public class Calculator {
    /**
     * @param zipFilePath -  path to zip archive with text files
     * @param character   - character to find
     * @return - how many times character is in files
     */
    public Integer getNumberOfChar(String zipFilePath, char character) {
        if (zipFilePath == null){
            throw new IllegalArgumentException ("The path cannot be null");
        }
        int count = 0;
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(zipFilePath))) {
            while (zip.getNextEntry() != null) {
                Scanner in = new Scanner(zip, "UTF-8");
                in.useDelimiter("\n");
                while (in.hasNext()) {
                    String line = in.next();
                    if (line.contains(String.valueOf(character))) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    /**
     * @param zipFilePath - path to zip archive with text files
     * @return - max length
     */

    public Integer getMaxWordLength(String zipFilePath) {
        if (zipFilePath == null){
            throw new IllegalArgumentException ("The path cannot be null");
        }
        int count = 0;
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(zipFilePath))) {
            while (zip.getNextEntry() != null) {
                Scanner in = new Scanner(zip, "UTF-8");
                in.useDelimiter("\n");
                while (in.hasNext()) {
                    String[] arrays = in.next().split("\\s+");
                    for (String ch : arrays) {
                        if (ch.length() > count) {
                            count = ch.length();
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
}