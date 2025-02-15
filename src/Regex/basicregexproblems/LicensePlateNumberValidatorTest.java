package com.capgeminitraining.week4.day5regexjunit.regex.basicregexproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LicensePlateNumberValidatorTest {

    @Test
    void testValidLicensePlates() {
        assertTrue(LicensePlateNumberValidator.isValidLicense("AB1234"), "AB1234 should be valid");
        assertTrue(LicensePlateNumberValidator.isValidLicense("XY9876"), "XY9876 should be valid");
    }

    @Test
    void testInvalidLicensePlates() {
        assertFalse(LicensePlateNumberValidator.isValidLicense("A12345"), "Missing one letter");
        assertFalse(LicensePlateNumberValidator.isValidLicense("ABC123"), "Too many letters");
        assertFalse(LicensePlateNumberValidator.isValidLicense("AB12"), "Too short");
        assertFalse(LicensePlateNumberValidator.isValidLicense("ab1234"), "Lowercase letters not allowed");
        assertFalse(LicensePlateNumberValidator.isValidLicense("AB12345"), "Too many digits");
        assertFalse(LicensePlateNumberValidator.isValidLicense("1234AB"), "Incorrect format");
    }

    @Test
    void testEmptyOrNullInput() {
        assertFalse(LicensePlateNumberValidator.isValidLicense(""), "Empty string should be invalid");
        assertThrows(NullPointerException.class, () -> LicensePlateNumberValidator.isValidLicense(null), "Null input should throw NullPointerException");
    }
}
