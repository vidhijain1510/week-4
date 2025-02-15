package com.capgeminitraining.week4.day5regexjunit.regex.basicregexproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UsernameValidatorTest {

    @Test
    void testValidUsernames() {
        assertTrue(UsernameValidator.isValidUsername("user_123"), "user_123 should be valid");
        assertTrue(UsernameValidator.isValidUsername("JohnDoe"), "JohnDoe should be valid");
        assertTrue(UsernameValidator.isValidUsername("A_1b2C"), "A_1b2C should be valid");
    }

    @Test
    void testInvalidUsernames() {
        assertFalse(UsernameValidator.isValidUsername("123user"), "123user should be invalid (starts with a number)");
        assertFalse(UsernameValidator.isValidUsername("us"), "us should be invalid (too short)");
        assertFalse(UsernameValidator.isValidUsername("a_very_long_username"), "Too long username");
        assertFalse(UsernameValidator.isValidUsername("user@name"), "Special character '@' not allowed");
        assertFalse(UsernameValidator.isValidUsername("User-Name"), "Hyphen '-' not allowed");
    }

    @Test
    void testEdgeCases() {
        assertFalse(UsernameValidator.isValidUsername(""), "Empty string should be invalid");
        assertFalse(UsernameValidator.isValidUsername("_user"), "Cannot start with underscore");
        assertThrows(NullPointerException.class, () -> UsernameValidator.isValidUsername(null), "Null input should throw NullPointerException");
    }
}
