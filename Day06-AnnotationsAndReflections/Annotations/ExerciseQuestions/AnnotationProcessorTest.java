package com.capgeminitraining.week4.day6annotationsreflection.annotations.exercisequestion;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class AnnotationProcessorTest {
    @Test
    void testTaskInfoAnnotation() throws NoSuchMethodException {
        Method method = TaskManager.class.getMethod("completeReport");

        assertTrue(method.isAnnotationPresent(TaskInfo.class));

        TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
        assertEquals("High", taskInfo.priority());
        assertEquals("Alice", taskInfo.assignedTo());
    }

}