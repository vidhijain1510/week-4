package com.capgeminitraining.week4.day2.MapInterface;

import static org.junit.jupiter.api.Assertions.*;

import com.capgeminitraining.week4.day2.QueueInterface.CircularBuffer;
import org.junit.jupiter.api.Test;


class CircularBufferTest {
    @Test
    void testInsertionAndRetrieval() {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        assertArrayEquals(new Integer[]{1, 2, 3}, buffer.getBufferContents());

        buffer.insert(4);
        assertArrayEquals(new Integer[]{2, 3, 4}, buffer.getBufferContents());
    }

    @Test
    void testOverwrite() {
        CircularBuffer<String> buffer = new CircularBuffer<>(2);
        buffer.insert("A");
        buffer.insert("B");
        buffer.insert("C");
        assertArrayEquals(new String[]{"B", "C"}, buffer.getBufferContents());
    }

    @Test
    void testEmptyBuffer() {
        CircularBuffer<Double> buffer = new CircularBuffer<>(3);
        assertArrayEquals(new Double[]{}, buffer.getBufferContents());
    }
}