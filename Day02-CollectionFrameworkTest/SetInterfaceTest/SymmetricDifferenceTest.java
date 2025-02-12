package com.capgeminitraining.week4.day2.SetInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.HashSet;

public class SymmetricDifferenceTest {

    @Test
    public void testGetSymmetricDifference() {
        //Test case 1
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> expected1 = new HashSet<>();
        expected1.add(1);
        expected1.add(2);
        expected1.add(4);
        expected1.add(5);

        Set<Integer> result1 = SymmetricDifference.getSymmetricDifference(set1, set2);
        assertEquals(expected1, result1);

        //Test case 2
        Set<Integer> set3 = new HashSet<>();
        Set<Integer> set4 = new HashSet<>();
        set3.add(1);
        set3.add(2);
        set4.add(3);
        set4.add(4);

        Set<Integer> expected2 = new HashSet<>();
        expected2.add(1);
        expected2.add(2);
        expected2.add(3);
        expected2.add(4);

        Set<Integer> result2 = SymmetricDifference.getSymmetricDifference(set3, set4);
        assertEquals(expected2, result2);
    }
}
