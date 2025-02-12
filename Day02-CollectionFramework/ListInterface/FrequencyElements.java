/*Find Frequency of Elements
Given a list of strings, count the frequency of each element and return the results in a Map<String, Integer>.
Example:
Input: ["apple", "banana", "apple", "orange"] → Output: {apple=2, banana=1, orange=1}.*/

package com.capgeminitraining.week4.day2.ListInterface;

import java.util.*;

public class FrequencyElements {
    //Method to find the frequency of words
    public static<T> Map<T, Integer> countFrequency(List<T> input){
        Map<T, Integer> frequency = new HashMap<>();
        for(T word : input){
            frequency.put(word, frequency.getOrDefault(word, 0)+1);
        }
        return  frequency;
    }

    //Main Method
    public static void main(String[] args) {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> frequency = countFrequency(input); //Calling method to count the frequency
        System.out.println(frequency);
    }
}