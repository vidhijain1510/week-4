package com.capgeminitraining.week4.day5regexjunit.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

class TaskTest {

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Fails if execution time exceeds 2 seconds
    void testLongRunningTask() {
        PerformanceTest performanceTest = new PerformanceTest();
        assertEquals("Completed", performanceTest.longRunningTask());
    }
}
