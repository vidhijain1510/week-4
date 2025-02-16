package com.capgeminitraining.week4.day6annotationsreflection.reflections.basiclevel;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccessPrivateTest {
    @Test
    void testPrivateFieldAccess() throws NoSuchFieldException, IllegalAccessException {
        //Creating a Person instance with initial age 25
        Person person = new Person(25);

        //Getting the private field "age" using reflection
        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);

        //Verifying initial age value
        int initialAge = (int) ageField.get(person);
        assertEquals(25, initialAge, "Initial age should be 25");

        //Modifying the age field
        ageField.set(person, 30);

        //Verifying the modified age value
        int modifiedAge = (int) ageField.get(person);
        assertEquals(30, modifiedAge, "Modified age should be 30");
    }
}