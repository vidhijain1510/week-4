/*File Handling - Read and Write a Text File
📌 Problem Statement:
Write a Java program that reads the contents of a text file and writes it into a new file.
If the source file does not exist, display an appropriate message.
Requirements:
Use FileInputStream and FileOutputStream.
Handle IOException properly.
Ensure that the destination file is created if it does not exist.
*/

package com.capgeminitraining.week4.day3javastreams;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        //Source and destination file paths
        String sourceFile = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\main\\java\\com\\capgeminitraining\\week4\\day3javastreams\\source.txt";
        String destinationFile = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\main\\java\\com\\capgeminitraining\\week4\\day3javastreams\\destination.txt";

        //resources to handle closing streams automatically
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            //Buffer to hold read data
            byte[] buffer = new byte[1024];
            int bytesRead;

            //Reading and writing data
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully!");

        } catch (FileNotFoundException e) {
            System.err.println("Error: Source file does not exist.");
        } catch (IOException e) {
            System.err.println("Error: An IO exception occurred - " + e.getMessage());
        }
    }
}

