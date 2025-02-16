package com.capgeminitraining.week4.day6annotationsreflection.reflections.basiclevel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ClassInformationTest {
    @Test
    void testInspectStringClass() {
        String output = ClassInformation.inspectClass("java.lang.String");
        assertTrue(output.contains("Class: java.lang.String"));
        assertTrue(output.contains("Constructors:"));
        assertTrue(output.contains("Fields:"));
        assertTrue(output.contains("Methods:"));
    }

    @Test
    void testClassNotFound() {
        String output = ClassInformation.inspectClass("non.existent.Class");
        assertTrue(output.contains("Class not found"));
    }
}
