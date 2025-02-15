package com.capgeminitraining.week4.day5regexjunit.junit.advancejunit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Secure123"), "Valid password should return true.");
    }

    @Test
    void testShortPassword() {
        assertFalse(PasswordValidator.isValid("Short1"), "Password with less than 8 characters should return false.");
    }

    @Test
    void testMissingUppercase() {
        assertFalse(PasswordValidator.isValid("secure123"), "Password without an uppercase letter should return false.");
    }

    @Test
    void testMissingDigit() {
        assertFalse(PasswordValidator.isValid("SecurePass"), "Password without a digit should return false.");
    }

    @Test
    void testNullPassword() {
        assertFalse(PasswordValidator.isValid(null), "Null password should return false.");
    }

    @Test
    void testPasswordWithSpecialCharacters() {
        assertTrue(PasswordValidator.isValid("P@ssword1"), "Password with special characters should be valid if other criteria are met.");
    }
}
