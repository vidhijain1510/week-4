package com.capgeminitraining.week4.day5regexjunit.junit.advancejunit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {

    @Test
    void testValidDateConversion() {
        assertEquals("25-12-2023", DateFormatter.formatDate("2023-12-25"), "Should convert to dd-MM-yyyy format");
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"), "Should convert to dd-MM-yyyy format");
    }

    @Test
    void testInvalidDateFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("25-12-2023"));
        assertEquals("Invalid date format. Expected yyyy-MM-dd.", exception.getMessage(), "Should reject incorrect format");
    }




    @Test
    void testEmptyInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate(""));
        assertEquals("Invalid date format. Expected yyyy-MM-dd.", exception.getMessage(), "Should reject empty input");
    }
}
