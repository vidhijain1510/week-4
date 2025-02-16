package com.capgeminitraining.week4.day6annotationsreflection.annotations.intermediatelevel;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ExecutionTimeLoggerTest {
    @Test
    void testLogExecutionTimeAnnotationExists() throws NoSuchMethodException {
        //Methods from PerformanceTest class
        Method fastMethod = PerformanceTest.class.getMethod("fastMethod");
        Method slowMethod = PerformanceTest.class.getMethod("slowMethod");
        Method normalMethod = PerformanceTest.class.getMethod("normalMethod");

        LogExecutionTime fastAnnotation = fastMethod.getAnnotation(LogExecutionTime.class);
        LogExecutionTime slowAnnotation = slowMethod.getAnnotation(LogExecutionTime.class);
        LogExecutionTime normalAnnotation = normalMethod.getAnnotation(LogExecutionTime.class);

        assertNotNull(fastAnnotation, "fastMethod should have @LogExecutionTime annotation");
        assertNotNull(slowAnnotation, "slowMethod should have @LogExecutionTime annotation");

        assertNull(normalAnnotation, "normalMethod should not have @LogExecutionTime annotation");
    }

    @Test
    void testExecutionTimeMeasurement() throws Exception {
        //Creating an instance of PerformanceTest
        PerformanceTest testObject = new PerformanceTest();
        Method slowMethod = PerformanceTest.class.getMethod("slowMethod");

        long startTime = System.nanoTime();
        slowMethod.invoke(testObject);
        long endTime = System.nanoTime();

        long executionTime = (endTime - startTime) / 1_000_000;

        assertTrue(executionTime >= 500, "Execution time should be at least 500ms");
    }
}