/*1️⃣4️⃣ Find Repeating Words in a Sentence
🔹 Example Input:
"This is is a repeated repeated word test."
🔹 Expected Output:
is, repeated*/
package com.capgeminitraining.week4.day5regexjunit.regex.advanceproblem;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatingWords {
    //Method to find the Repeating Words
    public static Set<String> findRepeatingWords(String text) {
        //Regex to match words
        String regex = "\\b(\\w+)\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        //Map to count word occurrences
        Map<String, Integer> wordCount = new HashMap<>();

        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); //Converting to lowercase for case insensitive matching
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        //Collecting words that appear more than once
        Set<String> repeatingWords = new HashSet<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                repeatingWords.add(entry.getKey());
            }
        }
        return repeatingWords;
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        Set<String> repeatingWords = findRepeatingWords(text);

        if (repeatingWords.isEmpty()) {
            System.out.println("No repeating words found.");
        } else {
            System.out.println("Repeating Words are: " + String.join(", ", repeatingWords));
        }
    }
}
