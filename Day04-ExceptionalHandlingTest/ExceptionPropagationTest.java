package com.capgeminitraining.week4.day4exceptionalhandling;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExceptionPropagationTest {

    //Test for method1 (throws ArithmeticException)
    @Test
    public void testMethod1ThrowsException() {
        //Checking if method1 throws an ArithmeticException
        assertThrows(ArithmeticException.class, () -> ExceptionPropagation.method1());
    }

    //Test for method2 (propagates ArithmeticException)
    @Test
    public void testMethod2ThrowsException() {
        //Checking if method2 propagates the exception from method1
        assertThrows(ArithmeticException.class, () -> ExceptionPropagation.method2());
    }
}