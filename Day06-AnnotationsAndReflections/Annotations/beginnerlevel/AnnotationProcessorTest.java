package com.capgeminitraining.week4.day6annotationsreflection.annotations.beginnerlevel;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class AnnotationProcessorTest {
    @Test
    void testImportantMethodAnnotationExists() throws NoSuchMethodException {

        Method criticalMethod = TaskProcessor.class.getMethod("processImportantTask");
        Method highMethod = TaskProcessor.class.getMethod("processRegularTask");

        ImportantMethod criticalAnnotation = criticalMethod.getAnnotation(ImportantMethod.class);
        ImportantMethod highAnnotation = highMethod.getAnnotation(ImportantMethod.class);

        assertNotNull(criticalAnnotation, "Annotation should exist on processImportantTask");
        assertNotNull(highAnnotation, "Annotation should exist on processRegularTask");

        assertEquals("CRITICAL", criticalAnnotation.level(), "Expected CRITICAL importance level");
        assertEquals("HIGH", highAnnotation.level(), "Expected HIGH importance level");
    }

    @Test
    void testMethodWithoutAnnotation() throws NoSuchMethodException {
        Method normalMethod = TaskProcessor.class.getMethod("normalTask");

        ImportantMethod annotation = normalMethod.getAnnotation(ImportantMethod.class);

        assertNull(annotation, "normalTask should not have @ImportantMethod annotation");
    }

}