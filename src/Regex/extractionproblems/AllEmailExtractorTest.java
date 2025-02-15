package com.capgeminitraining.week4.day5regexjunit.regex.extractionproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class AllEmailExtractorTest {

    @Test
    void testExtractEmails() {
        assertEquals(
                List.of("support@example.com", "info@company.org"),
                AllEmailExtractor.extractEmails("Contact us at support@example.com and info@company.org")
        );

        assertEquals(
                List.of("user123@test.net"),
                AllEmailExtractor.extractEmails("Send a message to user123@test.net.")
        );

        assertEquals(
                List.of(),
                AllEmailExtractor.extractEmails("No emails in this text.")
        );
    }
}
