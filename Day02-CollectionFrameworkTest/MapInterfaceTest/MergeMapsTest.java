package com.capgeminitraining.week4.day2.MapInterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class MergeMapsTest {

    @Test
    public void testMergeMaps() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> expectedMergedMap = new HashMap<>();
        expectedMergedMap.put("A", 1);
        expectedMergedMap.put("B", 5);
        expectedMergedMap.put("C", 4);

        Map<String, Integer> mergedMap = MergeMaps.mergeMaps(map1, map2);
        assertEquals(expectedMergedMap, mergedMap, "The merged map is not correct.");
    }
}
