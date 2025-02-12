package com.capgeminitraining.week4.day2.ListInterface;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ReversingListTest {

    @Test
    void testingArrayList(){
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expectedOutput = Arrays.asList(5, 4, 3, 2, 1);
        List<Integer> result = ReversingList.reverseArrayList(new ArrayList<>(input));
        assertEquals(expectedOutput, result);
    }

    @Test
    void testingLinkedList(){
        List<Integer> input1 = Arrays.asList(1,2,3,4,5);
        List<Integer> expectedOutput1 = Arrays.asList(5,4,3,2,1);
        List<Integer> result1 = ReversingList.reverseLinkedList(new LinkedList<>(input1));
        assertEquals(expectedOutput1, result1);
    }
}