package com.capgeminitraining.week4.day5regexjunit.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class ListManagerTest {

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        ListManager.addElement(list, 5);
        assertTrue(list.contains(5));
        assertEquals(1, list.size());
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);

        assertTrue(ListManager.removeElement(list, 10)); // Element should be removed
        assertFalse(list.contains(10)); // List should not contain 10 anymore
        assertEquals(1, list.size()); // Size should be reduced

        assertFalse(ListManager.removeElement(list, 30)); // Element not in the list, should return false
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, ListManager.getSize(list)); // Initially empty

        list.add(1);
        list.add(2);
        assertEquals(2, ListManager.getSize(list)); // Size after adding elements
    }
}
