package com.capgeminitraining.week4.day5regexjunit.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionHandlerTest {

    @Test
    void testDivideValidCase() {
        assertEquals(5, ExceptionHandler.divide(10, 2)); // 10 / 2 = 5
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            ExceptionHandler.divide(10, 0);
        });

        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
