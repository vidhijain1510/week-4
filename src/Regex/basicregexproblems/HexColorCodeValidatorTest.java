package com.capgeminitraining.week4.day5regexjunit.regex.basicregexproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HexColorCodeValidatorTest {

    @Test
    void testValidHexCodes() {
        assertTrue(HexColorCodeValidator.isValidHexColorCode("#FFA500"), "Valid hex color");
        assertTrue(HexColorCodeValidator.isValidHexColorCode("#ff4500"), "Valid lowercase hex color");
        assertTrue(HexColorCodeValidator.isValidHexColorCode("#00FF00"), "Valid hex color");
    }

    @Test
    void testInvalidHexCodes() {
        assertFalse(HexColorCodeValidator.isValidHexColorCode("FFA500"), "Missing # should be invalid");
        assertFalse(HexColorCodeValidator.isValidHexColorCode("#123"), "Too short should be invalid");
        assertFalse(HexColorCodeValidator.isValidHexColorCode("#12345G"), "Contains invalid character");
        assertFalse(HexColorCodeValidator.isValidHexColorCode("#ABCDE"), "Too short should be invalid");
        assertFalse(HexColorCodeValidator.isValidHexColorCode("#1234567"), "Too long should be invalid");
    }
}
