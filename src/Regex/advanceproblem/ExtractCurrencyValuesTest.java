package com.capgeminitraining.week4.day5regexjunit.regex.advanceproblem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ExtractCurrencyValuesTest {

    @Test
    void testExtractCurrencyValues() {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> expected = List.of("$45.99", "10.50");
        assertEquals(expected, ExtractCurrencyValues.extractCurrency(text), "Should correctly extract currency values");
    }

    @Test
    void testExtractMultipleCurrencyValues() {
        String text = "Items cost $5.00, $99.99, and 120.00.";
        List<String> expected = List.of("$5.00", "$99.99", "120.00");
        assertEquals(expected, ExtractCurrencyValues.extractCurrency(text), "Should correctly extract multiple currency values");
    }
}