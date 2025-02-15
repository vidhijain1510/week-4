package com.capgeminitraining.week4.day5regexjunit.regex.advanceproblem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SocialSecurityNumberValidatorTest {

    @Test
    void testValidSSN() {
        assertTrue(SocialSecurityNumberValidator.isValidSSN("123-45-6789"), "Valid SSN should return true");
    }

    @Test
    void testInvalidSSN_MissingDashes() {
        assertFalse(SocialSecurityNumberValidator.isValidSSN("123456789"), "SSN without dashes should return false");
    }

    @Test
    void testInvalidSSN_WrongFormat() {
        assertFalse(SocialSecurityNumberValidator.isValidSSN("123-456-789"), "SSN with incorrect format should return false");
    }

    @Test
    void testInvalidSSN_LettersIncluded() {
        assertFalse(SocialSecurityNumberValidator.isValidSSN("123-AB-6789"), "SSN with letters should return false");
    }

    @Test
    void testInvalidSSN_ShortLength() {
        assertFalse(SocialSecurityNumberValidator.isValidSSN("12-34-5678"), "SSN too short should return false");
    }
}
