package com.capgeminitraining.week4.day6annotationsreflection.annotations.exercisequestion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class UncheckedWarningAnnotationTest {
    @Test
    void testAddElements() {
        UncheckedWarningAnnotation demo = new UncheckedWarningAnnotation();

        // Capture console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        demo.addElements();
        String output = out.toString().trim();

        assertTrue(output.contains("List elements:"));
    }

}