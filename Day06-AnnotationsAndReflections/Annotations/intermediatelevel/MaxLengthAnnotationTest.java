package com.capgeminitraining.week4.day6annotationsreflection.annotations.intermediatelevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxLengthAnnotationTest {

    @Test
    void testValidUsername() {
        assertDoesNotThrow(() -> new User("JohnDoe"), "Valid username should not throw an exception");
    }

    @Test
    void testUsernameExceedingMaxLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new User("VeryLongUsername"));
        assertTrue(exception.getMessage().contains("exceeds max length"), "Exception should indicate max length exceeded");
    }

    @Test
    void testEdgeCaseMaxLength() {
        assertDoesNotThrow(() -> new User("1234567890"), "Username with exactly 10 characters should be allowed");
    }

    @Test
    void testEmptyUsername() {
        assertDoesNotThrow(() -> new User(""), "Empty username should be allowed if no min length constraint exists");
    }

}