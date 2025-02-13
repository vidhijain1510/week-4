/* try-with-resources (Auto-closing Resources)
💡 Problem Statement:
Write a Java program that reads the first line of a file named "info.txt" using BufferedReader.
Use try-with-resources to ensure the file is automatically closed after reading.
Handle any IOException that may occur.
Expected Behavior:
If the file exists, print its first line.
If the file does not exist, catch IOException and print "Error reading file".
*/

package com.capgeminitraining.week4.day4exceptionalhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReader2 {
    public static String readFirstLine(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return br.readLine();
        } catch (IOException e) {
            return "Error reading file";
        }
    }

    public static void main(String[] args) {
        String fileName = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\main\\java\\com\\capgeminitraining\\week4\\day4exceptionalhandling\\info.txt";
        System.out.println(readFirstLine(fileName));
    }
}

