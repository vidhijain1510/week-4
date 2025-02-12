package com.capgeminitraining.week4.day2.ListInterface;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RotateListTest {
    @Test
    void rotateListTest(){
        List<Integer> input = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> expected = Arrays.asList(30, 40, 50, 10, 20);
        int k = 2;
        List<Integer> rotatedList = RotateList.rotateElement(input, k);
        assertEquals(expected, rotatedList);
    }
}