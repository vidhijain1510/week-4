package com.capgeminitraining.week4.day2.QueueInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Queue;
import java.util.LinkedList;

public class QueueReverseTest {
    @Test
    public void testReverseQueue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        QueueReverse.reverseQueue(queue);
        Queue<Integer> expected = new LinkedList<>();
        expected.add(30);
        expected.add(20);
        expected.add(10);
        assertEquals(expected, queue);
    }
}
