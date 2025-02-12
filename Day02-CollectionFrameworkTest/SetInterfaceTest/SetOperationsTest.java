package com.capgeminitraining.week4.day2.SetInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.HashSet;

public class SetOperationsTest {

    @Test
    public void testGetUnion() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> expectedUnion = new HashSet<>();
        expectedUnion.add(1);
        expectedUnion.add(2);
        expectedUnion.add(3);
        expectedUnion.add(4);
        expectedUnion.add(5);

        Set<Integer> resultUnion = SetOperations.getUnion(set1, set2);
        assertEquals(expectedUnion, resultUnion);

    }

    @Test
    public void testGetIntersection() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> expectedIntersection = new HashSet<>();
        expectedIntersection.add(3);

        Set<Integer> resultIntersection = SetOperations.getIntersection(set1, set2);
        assertEquals(expectedIntersection, resultIntersection);
    }
}
