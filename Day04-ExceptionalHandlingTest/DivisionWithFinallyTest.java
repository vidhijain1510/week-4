package com.capgeminitraining.week4.day4exceptionalhandling;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DivisionWithFinallyTest {

    @Test
    public void testValidDivision() {
        String result = DivisionWithFinally.divide(10, 2);
        assertEquals("Result of division: 5", result);
    }

    @Test
    public void testDivisionByZero() {
        String result = DivisionWithFinally.divide(10, 0);
        assertEquals("Error: Division by zero is not allowed.", result);
    }
}