package com.capgeminitraining.week4.day2.ListInterface;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.capgeminitraining.week4.day2.ListInterface.DuplicateRemove.removeDuplicate;
import static org.junit.jupiter.api.Assertions.*;

class DuplicateRemoveTest {
    @Test
    void test() {
        List<Integer> input = Arrays.asList(5, 2, 17, 3, 1, 2, 2, 3, 4);
        List<Integer> results = removeDuplicate(input);
        List<Integer> expected = Arrays.asList(5, 2, 17, 3, 1, 4);
        assertEquals(expected, results);
    }
}