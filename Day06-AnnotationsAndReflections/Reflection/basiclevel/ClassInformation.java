/*Get Class Information: Write a program to accept a class name as input and display its methods, fields,
and constructors using Reflection.*/

package com.capgeminitraining.week4.day6annotationsreflection.reflections.basiclevel;

import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();
        scanner.close();

        inspectClass(className);
    }

    public static String inspectClass(String className) {
        StringBuilder result = new StringBuilder();
        try {
            Class<?> clazz = Class.forName(className);
            result.append("Class: ").append(clazz.getName()).append("\n");

            result.append("\nConstructors:\n");
            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                result.append(constructor).append("\n");
            }

            result.append("\nFields:\n");
            for (Field field : clazz.getDeclaredFields()) {
                result.append(field).append("\n");
            }

            result.append("\nMethods:\n");
            for (Method method : clazz.getDeclaredMethods()) {
                result.append(method).append("\n");
            }
        } catch (ClassNotFoundException e) {
            result.append("Class not found: ").append(className).append("\n");
        }
        System.out.print(result.toString());
        return result.toString();
    }
}
