package com.capgeminitraining.week4.day4exceptionalhandling;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

class DivisionCalculatorTest {

    @Test
    void testValidDivision() {
        String input = "10\n2\n"; // 10 / 2 = 5
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = DivisionCalculator.divideNumbers();
        assertEquals("Result: 5", result);
    }

    @Test
    void testDivisionByZero() {
        String input = "10\n0\n"; // Division by zero
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = DivisionCalculator.divideNumbers();
        assertEquals("Error: Division by zero is not allowed.", result);
    }

    @Test
    void testNonNumericInput() {
        String input = "10\na\n"; // Non-numeric denominator
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = DivisionCalculator.divideNumbers();
        assertEquals("Error: Please enter numeric values only.", result);
    }
}