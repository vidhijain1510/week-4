package com.capgeminitraining.week4.day2.QueueInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.PriorityQueue;

class HospitalTriageTest {
    @Test
    void testPatientOrdering() {
        PriorityQueue<Patient> queue = new PriorityQueue<>(Comparator.comparingInt((Patient p) -> -p.severity));
        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        assertEquals("Alice (Severity: 5)", queue.poll().toString());
        assertEquals("John (Severity: 3)", queue.poll().toString());
        assertEquals("Bob (Severity: 2)", queue.poll().toString());
    }

    @Test
    void testEmptyQueue() {
        PriorityQueue<Patient> queue = new PriorityQueue<>(Comparator.comparingInt((Patient p) -> -p.severity));
        assertNull(queue.poll());
    }
}
