/*Filter Streams - Convert Uppercase to Lowercase
📌 Problem Statement:
Create a program that reads a text file and writes its contents into another file, converting all uppercase letters to lowercase.
Requirements:
Use FileReader and FileWriter.
Use BufferedReader and BufferedWriter for efficiency.
Handle character encoding issues.
*/

package com.capgeminitraining.week4.day3javastreams;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class UpperCaseToLowerCase {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\main\\resources\\UpperCaseCharacter.txt";
        String outputFilePath = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\main\\resources\\LowerCaseCharacter.txt";

        try {
            convertToLowerCase(inputFilePath, outputFilePath);

            System.out.println("Conversion completed!");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    //Method to convert uppercase to lowercase
    public static void convertToLowerCase(String inputFilePath, String outputFilePath) throws IOException{
        try (
            FileReader fileReader = new FileReader(inputFilePath, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(outputFilePath, StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){

            String line;
            while ((line = bufferedReader.readLine()) != null){
                String lowerCaseLine = line.toLowerCase();
                bufferedWriter.write(lowerCaseLine);
                bufferedWriter.newLine();
            }
        }
    }
}
