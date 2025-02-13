/*Buffered Streams - Efficient File Copy
📌 Problem Statement:
Create a Java program that copies a large file (e.g., 100MB) from one location to another using Buffered Streams
(BufferedInputStream and BufferedOutputStream). Compare the performance with normal file streams.
Requirements:
Read and write in chunks of 4 KB (4096 bytes).
Use System.nanoTime() to measure execution time.
Compare execution time with unbuffered streams.*/
package com.capgeminitraining.week4.day3javastreams;

import java.io.*;
import java.nio.file.*;

public class CopyLargeFile {

    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) throws IOException {
        String sourceFilePath = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\main\\resources\\30MB_text_file.txt";
        String destinationFileBufferedPath = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\main\\resources\\DestinationFileBuffer.txt";
        String destinationFileUnbufferedPath = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\main\\resources\\DestinationFileUnbuffer.txt";

        //Creating test files (large file)
        generateLargeFile(sourceFilePath);

        //Measuring the time for Buffered copy
        long startTimeBuffered = System.nanoTime();
        copyFileBuffered(sourceFilePath, destinationFileBufferedPath);
        long endTimeBuffered = System.nanoTime();
        System.out.println("Buffered copy took: " + (endTimeBuffered - startTimeBuffered) + " ns");

        //Measuring the time for Unbuffered copy
        long startTimeUnbuffered = System.nanoTime();
        copyFileUnbuffered(sourceFilePath, destinationFileUnbufferedPath);
        long endTimeUnbuffered = System.nanoTime();
        System.out.println("Unbuffered copy took: " + (endTimeUnbuffered - startTimeUnbuffered) + " ns");

        //Cleaning up the test files
        Files.delete(Paths.get(sourceFilePath));
        Files.delete(Paths.get(destinationFileBufferedPath));
        Files.delete(Paths.get(destinationFileUnbufferedPath));
    }

    //Method to copy using Buffered Streams
    static void copyFileBuffered(String sourceFilePath, String destinationFilePath) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFilePath));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFilePath))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
    }

    //Method to copy using Unbuffered Streams
    static void copyFileUnbuffered(String sourceFilePath, String destinationFilePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destinationFilePath)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    //Method to generate a large test file
    private static void generateLargeFile(String filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] data = new byte[BUFFER_SIZE];
            for (int i = 0; i < 100 * 1024; i++) {
                bos.write(data);
            }
        }
    }
}