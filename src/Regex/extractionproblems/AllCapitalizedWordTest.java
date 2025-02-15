package com.capgeminitraining.week4.day5regexjunit.regex.extractionproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class AllCapitalizedWordTest {

    @Test
    void testExtractWords() {
        assertEquals(
                List.of("The", "Eiffel", "Tower", "Paris", "Statue", "Liberty", "New", "York"),
                AllCapitalizedWord.extractWords("The Eiffel Tower is in Paris and the Statue of Liberty is in New York.")
        );

        assertEquals(List.of("The","Sun", "Moon"),
                AllCapitalizedWord.extractWords("The Sun and Moon are visible in the sky.")
        );

        assertEquals(List.of(),
                AllCapitalizedWord.extractWords("hello world, this is a test.") // No capitalized words
        );
    }
}
