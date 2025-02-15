package com.capgeminitraining.week4.day5regexjunit.regex.advanceproblem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Set;

public class RepeatingWordsTest {

    @Test
    void testRepeatingWords() {
        String text = "This is is a repeated repeated word test.";
        Set<String> expected = Set.of("is", "repeated");
        assertEquals(expected, RepeatingWords.findRepeatingWords(text), "Repeating words should be detected correctly");
    }

    @Test
    void testNoRepeatingWords() {
        String text = "Every word is unique here.";
        assertTrue(RepeatingWords.findRepeatingWords(text).isEmpty(), "No repeating words should return an empty set");
    }

    @Test
    void testCaseInsensitiveMatching() {
        String text = "Hello hello WORLD world";
        Set<String> expected = Set.of("hello", "world");
        assertEquals(expected, RepeatingWords.findRepeatingWords(text), "Words should be matched case-insensitively");
    }

    @Test
    void testPunctuationHandling() {
        String text = "Hey! Hey, hey. HEY";
        Set<String> expected = Set.of("hey");
        assertEquals(expected, RepeatingWords.findRepeatingWords(text), "Punctuation should not affect word detection");
    }
}
