/*Dynamic Method Invocation: Define a class MathOperations with multiple public methods (add, subtract, multiply). Use Reflection to dynamically call any method based on user input.*/
package com.capgeminitraining.week4.day6annotationsreflection.reflections.intermediatelevel;

import java.util.Scanner;
import java.lang.reflect.Method;


class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            //Creating an instance of MathOperations
            MathOperations mathOperations = new MathOperations();
            Class<?> mathClass = mathOperations.getClass();

            //Getting user input for method name and parameters
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();
            scanner.close();

            //Retrieving the method dynamically
            Method method = mathClass.getMethod(methodName, int.class, int.class);

            //Invoking the method dynamically
            int result = (int) method.invoke(mathOperations, num1, num2);

            System.out.println("Result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
