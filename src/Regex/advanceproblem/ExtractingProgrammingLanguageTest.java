package com.capgeminitraining.week4.day5regexjunit.regex.advanceproblem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ExtractingProgrammingLanguageTest {

    @Test
    void testExtractProgrammingLanguages() {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> expected = List.of("Java", "Python", "JavaScript", "Go");
        assertEquals(expected, ExtractingProgrammingLanguage.extractLanguages(text), "Should correctly extract programming languages");
    }

    @Test
    void testNoProgrammingLanguages() {
        String text = "I enjoy painting and cooking.";
        assertTrue(ExtractingProgrammingLanguage.extractLanguages(text).isEmpty(), "Should return an empty list when no programming languages are found");
    }
}
