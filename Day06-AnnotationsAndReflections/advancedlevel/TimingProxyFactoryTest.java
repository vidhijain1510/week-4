package com.capgeminitraining.week4.day6annotationsreflection.reflections.advancedlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimingProxyFactoryTest {
    @Test
    void testMethodExecutionTime() {

        Task realTask = new TaskImpl();
        Task proxyTask = TimingProxyFactory.createProxy(realTask, Task.class);
        long start = System.nanoTime();
        proxyTask.execute();
        long end = System.nanoTime();

        long executionTime = (end - start) / 1_000_000;

        assertTrue(executionTime >= 500, "Execution time should be at least 500ms");
    }

}