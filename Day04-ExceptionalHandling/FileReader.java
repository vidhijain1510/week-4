/* 1. Checked Exception (Compile-time Exception)
💡 Problem Statement:
Create a Java program that reads a file named "data.txt". If the file does not exist, handle the IOException properly and display a user-friendly message.
Expected Behavior:
If the file exists, print its contents.
If the file does not exist, catch the IOException and print "File not found".
*/


package com.capgeminitraining.week4.day4exceptionalhandling;

import java.io.*;

public class FileReader {
    public static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            return "File not found";
        }
        return content.toString().trim();
    }

    public static void main(String[] args) {
        String fileName = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\main\\java\\com\\capgeminitraining\\week4\\day4exceptionalhandling\\data.txt";
        String result = readFile(fileName);
        System.out.println(result);
    }
}

