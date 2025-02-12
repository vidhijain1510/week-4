package com.capgeminitraining.week4.day2.MapInterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class MaxValueKeyTest {
    @Test
    public void testGetKeyWithMaxValue() {
        Map<String, Integer> inputMap1 = new HashMap<>();
        inputMap1.put("A", 10);
        inputMap1.put("B", 20);
        inputMap1.put("C", 15);

        String result1 = MaxValueKey.getKeyWithMaxValue(inputMap1);
        assertEquals("B", result1, "The key with the highest value should be B.");
    }
}
