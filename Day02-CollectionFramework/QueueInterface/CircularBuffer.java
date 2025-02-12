/*Circular Buffer Simulation
Implement a circular buffer (fixed-size queue) using an array-based queue. When full, overwrite the oldest element.
Example:
Buffer size=3: Insert 1, 2, 3 → Insert 4 → Buffer: [2, 3, 4].*/
package com.capgeminitraining.week4.day2.QueueInterface;

import java.util.Arrays;

public class CircularBuffer<T> {
    private Object[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void insert(T value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;
        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity; // Overwrite oldest element
        }
    }

    @SuppressWarnings("unchecked")
    public T[] getBufferContents() {
        Object[] contents = new Object[size];
        for (int i = 0; i < size; i++) {
            contents[i] = buffer[(head + i) % capacity];
        }
        return (T[]) contents;
    }

    public static void main(String[] args) {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        System.out.println("Buffer: " + Arrays.toString(buffer.getBufferContents())); // Output: [1, 2, 3]

        buffer.insert(4);
        System.out.println("Buffer: " + Arrays.toString(buffer.getBufferContents())); // Output: [2, 3, 4]
    }
}
