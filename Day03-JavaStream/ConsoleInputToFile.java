/*Read User Input from Console
📌 Problem Statement:
Write a program that asks the user for their name, age, and favorite programming language,
then saves this information into a file.
Requirements:
Use BufferedReader for console input.
Use FileWriter to write the data into a file.
Handle exceptions properly.
*/

package com.capgeminitraining.week4.day3javastreams;

import java.io.*;

public class ConsoleInputToFile {
    public static void main(String[] args) {
        String fileName = "user_data.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(fileName)) {

            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");

            System.out.println("User data saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while reading input or writing to file: " + e.getMessage());
        }
    }
}
