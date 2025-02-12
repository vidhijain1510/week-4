package com.capgeminitraining.week4.day2.QueueInterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackUsingQueuesTest {
    @Test
    void testPushAndPop() {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testTop() {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.top());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.top());
    }

    @Test
    void testEmpty() {
        StackUsingQueues stack = new StackUsingQueues();
        assertTrue(stack.empty());
        stack.push(5);
        assertFalse(stack.empty());
        stack.pop();
        assertTrue(stack.empty());
    }

    @Test
    void testPopOnEmptyStack() {
        StackUsingQueues stack = new StackUsingQueues();
        assertThrows(RuntimeException.class, stack::pop);
    }

    @Test
    void testTopOnEmptyStack() {
        StackUsingQueues stack = new StackUsingQueues();
        assertThrows(RuntimeException.class, stack::top);
    }
}