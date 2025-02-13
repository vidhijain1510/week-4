package com.capgeminitraining.week4.day4exceptionalhandling;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class NestedTryCatchTest {

    private String runTestWithInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        NestedTryCatch.main(new String[]{});
        return out.toString().trim();
    }

    @Test
    void testValidInput() {
        String input = "3\n10\n20\n30\n1\n2\n";
        String output = runTestWithInput(input);
        assertTrue(output.contains("Division result: 10"));
    }

    @Test
    void testArrayIndexOutOfBounds() {
        String input = "3\n10\n20\n30\n5\n2\n";
        String output = runTestWithInput(input);
        assertTrue(output.contains("Invalid array index!"));
    }

    @Test
    void testDivisionByZero() {
        String input = "3\n10\n20\n30\n1\n0\n";
        String output = runTestWithInput(input);
        assertTrue(output.contains("Cannot divide by zero!"));
    }
}
