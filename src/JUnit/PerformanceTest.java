package com.capgeminitraining.week4.day5regexjunit.junit;

public class PerformanceTest {
    public String longRunningTask() {
        try {
            Thread.sleep(1500); // Simulates a long-running operation (3 seconds)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
        return "Completed";
    }
}
