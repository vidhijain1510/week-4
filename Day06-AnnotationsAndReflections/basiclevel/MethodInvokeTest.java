package com.capgeminitraining.week4.day6annotationsreflection.reflections.basiclevel;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class MethodInvokeTest {
    @Test
    void testPrivateMethodInvocation() throws Exception {
        //Creating a Calculator instance
        Calculator calculator = new Calculator();

        //Getting the private method "multiply"
        Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);

        //Making the private method accessible
        multiplyMethod.setAccessible(true);

        //Invoking the method with arguments (6, 7)
        int result = (int) multiplyMethod.invoke(calculator, 6, 7);

        //Verifying the result
        assertEquals(42, result, "multiply(6, 7) should return 42");
    }

}