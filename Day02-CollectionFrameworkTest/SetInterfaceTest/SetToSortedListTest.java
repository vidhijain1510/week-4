package com.capgeminitraining.week4.day2.SetInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class SetToSortedListTest {

    @Test
    public void testConvertSetToSortedList() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(5);
        set1.add(3);
        set1.add(9);
        set1.add(1);
        List<Integer> expected1 = List.of(1, 3, 5, 9);
        List<Integer> result1 = SetToSortedList.convertSetToSortedList(set1);
        assertEquals(expected1, result1);


        Set<Integer> set2 = new HashSet<>();
        set2.add(7);
        List<Integer> expected2 = List.of(7);
        List<Integer> result2 = SetToSortedList.convertSetToSortedList(set2);
        assertEquals(expected2, result2);
    }
}
