package com.capgeminitraining.week4.day5regexjunit.regex.extractionproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ExtractingLinksTest {

    @Test
    void testValidLinks() {
        String text = "Check https://www.google.com and http://example.org";
        List<String> result = ExtractingLinks.extractLinks(text);
        assertEquals(List.of("https://www.google.com", "http://example.org"), result);
    }

    @Test
    void testNoLinks() {
        String text = "No links here!";
        List<String> result = ExtractingLinks.extractLinks(text);
        assertTrue(result.isEmpty());
    }
}
