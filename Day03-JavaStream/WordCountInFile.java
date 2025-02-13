/*Count Words in a File
📌 Problem Statement:
Write a Java program that counts the number of words in a given text file and displays the top 5 most frequently occurring words.
Requirements:
Use FileReader and BufferedReader to read the file.
Use a HashMap<String, Integer> to count word occurrences.
Sort the words based on frequency and display the top 5.
*/

package com.capgeminitraining.week4.day3javastreams;

import java.io.*;
import java.util.*;

public class WordCountInFile {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\main\\resources\\WordCountInFile.txt";

        //Using a HashMap to count the frequency of each word
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            //Reading the file line by line
            while ((line = reader.readLine()) != null) {
                //Splitting the line into words
                String[] words = line.split("\\W+"); // Use non-word characters as delimiters

                //Updating the word count map
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase(); // Convert to lowercase to count words case-insensitively
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            //Sorting the words based on frequency
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());
            sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

            //Displaying the total word count and top 5 most frequent words
            System.out.println("Total words in the file: " + wordCountMap.size());

            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < 5 && i < sortedList.size(); i++) {
                Map.Entry<String, Integer> entry = sortedList.get(i);
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
