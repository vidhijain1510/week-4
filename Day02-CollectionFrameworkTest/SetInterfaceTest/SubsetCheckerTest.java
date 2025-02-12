package com.capgeminitraining.week4.day2.SetInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.HashSet;

public class SubsetCheckerTest {

    @Test
    public void testIsSubset() {
        //Test case 1
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(2);
        set1.add(3);
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        assertTrue(SubsetChecker.isSubset(set1, set2));

        //Test case 2
        Set<Integer> set3 = new HashSet<>();
        Set<Integer> set4 = new HashSet<>();
        set3.add(2);
        set3.add(5);  // 5 is not in set4
        set4.add(1);
        set4.add(2);
        set4.add(3);
        set4.add(4);

        assertFalse(SubsetChecker.isSubset(set3, set4));

    }
}
