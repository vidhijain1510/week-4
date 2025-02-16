package com.capgeminitraining.week4.day6annotationsreflection.reflections.intermediatelevel;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class DynamicMethodInvocationTest {

    @Test
    void testAddMethodInvocation() throws Exception {
        MathOperations mathOperations = new MathOperations();
        Class<?> mathClass = mathOperations.getClass();
        Method method = mathClass.getMethod("add", int.class, int.class);
        int result = (int) method.invoke(mathOperations, 10, 5);
        assertEquals(15, result, "add(10, 5) should return 15");
    }

    @Test
    void testSubtractMethodInvocation() throws Exception {
        MathOperations mathOperations = new MathOperations();
        Method method = MathOperations.class.getMethod("subtract", int.class, int.class);
        int result = (int) method.invoke(mathOperations, 10, 5);

        assertEquals(5, result, "subtract(10, 5) should return 5");
    }

    @Test
    void testMultiplyMethodInvocation() throws Exception {
        MathOperations mathOperations = new MathOperations();
        Method method = MathOperations.class.getMethod("multiply", int.class, int.class);
        int result = (int) method.invoke(mathOperations, 6, 4);

        assertEquals(24, result, "multiply(6, 4) should return 24");
    }

    @Test
    void testInvalidMethodInvocation() {
        MathOperations mathOperations = new MathOperations();

        //Attempting to invoke a non-existent method should throw NoSuchMethodException
        assertThrows(NoSuchMethodException.class, () -> {
            MathOperations.class.getMethod("divide", int.class, int.class);
        });
    }
}