package com.capgeminitraining.week4.day2.ListInterface;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FrequencyElementsTest {

    @Test
    void frequencyElement(){
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> frequency = FrequencyElements.countFrequency(input);
        Map<String, Integer> expectedOutput = new HashMap<>();
        expectedOutput.put("apple", 2);
        expectedOutput.put("banana", 1);
        expectedOutput.put("orange", 1);
        assertEquals(expectedOutput, frequency);
    }

    @Test
    void frequencyElement1(){
        List<String> input = Arrays.asList("Vidhi", "Kapil", "Yaman", "Vidhi");
        Map<String, Integer> frequency = FrequencyElements.countFrequency(input);
        Map<String, Integer> expectedOutput = new HashMap<>();
        expectedOutput.put("Vidhi", 2);
        expectedOutput.put("Yaman", 1);
        expectedOutput.put("Kapil", 1);
        assertEquals(expectedOutput, frequency);
    }

}