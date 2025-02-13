package com.capgeminitraining.week4.day3javastreams;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CountWordsInFileTest {

    @Test
    void testWordCountAndTopWords() throws IOException { 
        String fileContent = "Java is great. Java is powerful.\n"
                + "Java is widely used. Java is fast.\n"
                + "Programming in Java is fun.";

        BufferedReader reader = new BufferedReader(new StringReader(fileContent));

        HashMap<String, Integer> wordCountMap = new HashMap<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\W+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    word = word.toLowerCase();
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCountMap.entrySet());
        sortedWords.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        List<String> topWords = new ArrayList<>();
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedWords) {
            if (count < 5) {
                topWords.add(entry.getKey() + ": " + entry.getValue());
                count++;
            } else {
                break;
            }
        }

        List<String> expectedTopWords = Arrays.asList(
                "java: 5",
                "is: 5",
                "fast: 1",
                "powerful: 1",
                "in: 1"
        );
        assertEquals(expectedTopWords, topWords);
    }
}
