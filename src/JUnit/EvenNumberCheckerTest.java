package com.capgeminitraining.week4.day5regexjunit.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenNumberCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6}) // Even numbers
    void testEvenNumbers(int number) {
        assertTrue(EvenNumberChecker.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9}) // Odd numbers
    void testOddNumbers(int number) {
        assertFalse(EvenNumberChecker.isEven(number), number + " should be odd");
    }
}
