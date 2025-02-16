package com.capgeminitraining.week4.day6annotationsreflection.reflections.basiclevel;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class DynamicObjectCreationTest {
    @Test
    void testDynamicObjectCreation() throws Exception {
        //Getting the Class object for Student
        Class<?> studentClass = Student.class;

        //Retrieving the no-argument constructor
        Constructor<?> constructor = studentClass.getDeclaredConstructor();

        //Creating an instance dynamically
        Object studentInstance = constructor.newInstance();

        //Accessing the getName() method using Reflection
        Method getNameMethod = studentClass.getMethod("getName");
        String name = (String) getNameMethod.invoke(studentInstance);

        //Verifying that the object is an instance of Student
        assertInstanceOf(Student.class, studentInstance, "The created object should be an instance of Student");

        //Verifying the default name
        assertEquals("Default Student", name, "Default name should be 'Default Student'");
    }

}