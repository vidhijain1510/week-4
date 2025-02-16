/*Invoke Private Method: Define a class Calculator with a private method multiply(int a, int b).
Use Reflection to invoke this method and display the result.*/
package com.capgeminitraining.week4.day6annotationsreflection.reflections.basiclevel;

import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class MethodInvoke {
    public static void main(String[] args) {
        try {
            //Creating an instance of Calculator
            Calculator calculator = new Calculator();

            //Getting the Class object
            Class<?> calculatorClass = calculator.getClass();

            //Retrieving the private method "multiply"
            Method multiplyMethod = calculatorClass.getDeclaredMethod("multiply", int.class, int.class);

            //Making the private method accessible
            multiplyMethod.setAccessible(true);

            //Invoking the method with arguments (5, 4)
            int result = (int) multiplyMethod.invoke(calculator, 5, 4);

            //Printing the result
            System.out.println("Result of multiply(5, 4): " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

