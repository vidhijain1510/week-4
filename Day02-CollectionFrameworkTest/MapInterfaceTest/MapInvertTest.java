package com.capgeminitraining.week4.day2.MapInterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class MapInvertTest {

    @Test
    public void testInvertMap() {
        //Test case 1: Typical case
        Map<String, Integer> inputMap1 = new HashMap<>();
        inputMap1.put("A", 1);
        inputMap1.put("B", 2);
        inputMap1.put("C", 1);

        Map<Integer, List<String>> expectedMap1 = new HashMap<>();
        expectedMap1.put(1, Arrays.asList("A", "C"));
        expectedMap1.put(2, Arrays.asList("B"));

        Map<Integer, List<String>> result1 = MapInvert.invertMap(inputMap1);
        assertEquals(expectedMap1, result1, "Inverted map does not match the expected map.");
    }
}
