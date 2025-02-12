package com.capgeminitraining.week4.day2.QueueInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class BinaryNumberGeneratorTest {

    @Test
    public void testGenerateBinaryNumbers() {
        int N = 5;
        List<String> expected = List.of("1", "10", "11", "100", "101");
        List<String> result = BinaryNumberGenerator.generateBinaryNumbers(N);
        assertEquals(expected, result);
    }
}
