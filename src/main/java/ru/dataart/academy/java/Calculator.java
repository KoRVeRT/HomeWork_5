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
        if (zipFilePath == null) {
            throw new IllegalArgumentException("The path cannot be null");
        }
        int count = 0;
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(zipFilePath))) {
            while (zip.getNextEntry() != null) {
                Scanner textFile = new Scanner(zip, "UTF-8");
                while (textFile.hasNext()) {
                    int indexWord = 0;
                    String line = textFile.nextLine();
                    while (line.indexOf(String.valueOf(character), indexWord) != -1) {
                        indexWord = line.indexOf(String.valueOf(character), indexWord) + 1;
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
        if (zipFilePath == null) {
            throw new IllegalArgumentException("The path cannot be null");
        }
        int maxCount = 0;
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(zipFilePath))) {
            while (zip.getNextEntry() != null) {
                Scanner textFile = new Scanner(zip, "UTF-8");
                while (textFile.hasNext()) {
                    String[] arraysWords = textFile.nextLine().split("\\s+");
                    for (String word : arraysWords) {
                        if (word.length() > maxCount) {
                            maxCount = word.length();
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return maxCount;
    }
}