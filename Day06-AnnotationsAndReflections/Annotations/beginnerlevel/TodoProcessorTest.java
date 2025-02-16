package com.capgeminitraining.week4.day6annotationsreflection.annotations.beginnerlevel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

class TodoProcessorTest {
    @Test
    void testTodoAnnotationExists() throws NoSuchMethodException {
        //Methods with @Todo annotation
        Method authMethod = FeatureDevelopment.class.getMethod("implementAuth");
        Method dbMethod = FeatureDevelopment.class.getMethod("optimizeDB");
        Method paymentMethod = FeatureDevelopment.class.getMethod("testPayments");

        //Retrieving annotations
        Todo authTodo = authMethod.getAnnotation(Todo.class);
        Todo dbTodo = dbMethod.getAnnotation(Todo.class);
        Todo paymentTodo = paymentMethod.getAnnotation(Todo.class);

        assertNotNull(authTodo, "implementAuth should have @Todo annotation");
        assertNotNull(dbTodo, "optimizeDB should have @Todo annotation");
        assertNotNull(paymentTodo, "testPayments should have @Todo annotation");

        assertEquals("Implement user authentication", authTodo.task());
        assertEquals("Vidhi", authTodo.assignedTo());
        assertEquals("HIGH", authTodo.priority());

        assertEquals("Optimize database queries", dbTodo.task());
        assertEquals("Suhani", dbTodo.assignedTo());
        assertEquals("MEDIUM", dbTodo.priority()); // Default value

        assertEquals("Write unit tests for payment module", paymentTodo.task());
        assertEquals("Shreasth", paymentTodo.assignedTo());
        assertEquals("LOW", paymentTodo.priority());
    }

    @Test
    void testMethodWithoutAnnotation() throws NoSuchMethodException {
        //Method without @Todo annotation
        class SampleClass {
            public void completedFeature() {}
        }

        Method completedMethod = SampleClass.class.getMethod("completedFeature");
        Todo annotation = completedMethod.getAnnotation(Todo.class);

        assertNull(annotation, "completedFeature should not have @Todo annotation");
    }

}