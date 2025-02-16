/*Dynamically Create Objects: Write a program to create an instance of a Student class
dynamically using Reflection without using the new keyword.*/
package com.capgeminitraining.week4.day6annotationsreflection.reflections.basiclevel;

import java.lang.reflect.Constructor;

class Student {
    private String name;

    public Student() {
        this.name = "Default Student";
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            //Use Student.class instead of Class.forName()
            Class<?> studentClass = Student.class;

            //Retrieving the no-argument constructor
            Constructor<?> constructor = studentClass.getDeclaredConstructor();

            //Creating an instance dynamically
            Object studentInstance = constructor.newInstance();

            //Invoking getName() using Reflection
            String name = (String) studentClass.getMethod("getName").invoke(studentInstance);

            System.out.println("Created object: " + studentInstance.getClass().getName());
            System.out.println("Student name: " + name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


