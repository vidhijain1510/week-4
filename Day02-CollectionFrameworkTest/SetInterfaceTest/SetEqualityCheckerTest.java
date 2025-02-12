package com.capgeminitraining.week4.day2.SetInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.HashSet;

public class SetEqualityCheckerTest {

    @Test
    public void testAreSetsEqual() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(3);
        set2.add(2);
        set2.add(1);
        assertTrue(SetEqualityChecker.areSetsEqual(set1, set2));

        Set<Integer> set3 = new HashSet<>();
        Set<Integer> set4 = new HashSet<>();
        set3.add(1);
        set3.add(2);
        set3.add(3);
        set4.add(4);
        set4.add(5);
        set4.add(6);
        assertFalse(SetEqualityChecker.areSetsEqual(set3, set4));
    }
}
