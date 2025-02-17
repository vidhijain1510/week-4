package com.capgeminitraining.week4.day6annotationsreflection.annotations.exercisequestion;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class BugReportProcessorTest {
    @Test
    void testBugReportAnnotation() throws NoSuchMethodException {
        Method method = SoftwareModule.class.getMethod("processData");

        assertTrue(method.isAnnotationPresent(BugReports.class));

        BugReports bugReports = method.getAnnotation(BugReports.class);
        assertEquals(2, bugReports.value().length);

        assertEquals("NullPointerException occurs when input is null.", bugReports.value()[0].description());
        assertEquals("Performance issue when processing large data sets.", bugReports.value()[1].description());
    }

}