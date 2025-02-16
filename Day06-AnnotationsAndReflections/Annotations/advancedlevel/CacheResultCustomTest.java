package com.capgeminitraining.week4.day6annotationsreflection.annotations.advancedlevel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CacheResultCustomTest {
    @Test
    void testCaching() {
        ExpensiveComputation computation = CacheProxyHandler.createProxy(new ExpensiveComputationImpl(), ExpensiveComputation.class);

        int result1 = computation.computeFactorial(4);
        int result2 = computation.computeFactorial(4);

        assertEquals(24, result1, "Factorial of 4 should be 24");
        assertEquals(result1, result2, "Cached result should match computed result");
    }

    @Test
    void testDifferentInputs() {
        ExpensiveComputation computation = CacheProxyHandler.createProxy(new ExpensiveComputationImpl(), ExpensiveComputation.class);

        int result1 = computation.computeFactorial(3);
        int result2 = computation.computeFactorial(5);

        assertEquals(6, result1, "Factorial of 3 should be 6");
        assertEquals(120, result2, "Factorial of 5 should be 120");
    }
}