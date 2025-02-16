/*Access Private Field: Create a class Person with a private field age. Use Reflection to modify and retrieve its value.*/
package com.capgeminitraining.week4.day6annotationsreflection.reflections.basiclevel;

import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
public class AccessPrivate {
    public static void main(String[] args) {
        try {
            //Creating a Person instance
            Person person = new Person(25);

            //Getting the Class object
            Class<?> personClass = person.getClass();

            //Accessing the private field "age"
            Field ageField = personClass.getDeclaredField("age");

            //Making the private field accessible
            ageField.setAccessible(true);

            System.out.println("Before modification: " + ageField.get(person));

            //Modifying the age field
            ageField.set(person, 30);

            System.out.println("After modification: " + ageField.get(person));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

