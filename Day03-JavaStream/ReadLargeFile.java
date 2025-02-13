/*Read a Large File Line by Line
📌 Problem Statement:
Develop a Java program that efficiently reads a large text file (500MB+) line by line and prints only lines containing the word "error".
Requirements:
Use BufferedReader for efficient reading.
Read line-by-line instead of loading the entire file.
Display only lines containing "error" (case insensitive).*/
package com.capgeminitraining.week4.day3javastreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeFile {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\main\\resources\\LargeFile500MB.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                //Trimming any leading/trailing whitespace
                line = line.trim();

                //Checking if the line contains the word "error"
                if (line.toLowerCase().contains("error")) {
                    System.out.println("Error found: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
