package com.capgeminitraining.week4.day2.MapInterface;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordFrequencyCounterTest {
    @Test
    void testWordFrequency() {
        String testContent = "Hello world, hello Java! Java is great.";
        String filePath = "test.txt";

        try (java.io.FileWriter writer = new java.io.FileWriter(filePath)) {
            writer.write(testContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Integer> expected = new HashMap<>();
        expected.put("hello", 2);
        expected.put("world", 1);
        expected.put("java", 2);
        expected.put("is", 1);
        expected.put("great", 1);

        assertEquals(expected, WordFrequencyCounter.countWordFrequency(filePath));
    }
}
