package com.capgeminitraining.week4.day5regexjunit.regex.extractionproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReplaceModifyStringsTest {

    @Test
    void testMultipleSpaces() {
        String text = "This   is   a    test.";
        assertEquals("This is a test.", ReplaceModifyStrings.replaceModifyStrings(text));
    }

    @Test
    void testNoExtraSpaces() {
        String text = "No extra spaces here.";
        assertEquals("No extra spaces here.", ReplaceModifyStrings.replaceModifyStrings(text));
    }
}
