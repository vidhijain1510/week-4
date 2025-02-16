package com.capgeminitraining.week4.day6annotationsreflection.reflections.advancedlevel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

class CustomObjectMapperTest {

    @Test
    void testToObject() {
        //Creating a properties map
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "Kapil");
        properties.put("age", 25);

        //Converting map to Person object
        Person person = CustomObjectMapper.toObject(Person.class, properties);

        //Verifying the mapped values
        assertEquals("Kapil", person.getName(), "Name should be 'Kapil'");
        assertEquals(25, person.getAge(), "Age should be 25");
    }

    @Test
    void testFieldNotFound() {
        //Creating a properties map with an extra field
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "suhani");
        properties.put("age", 20);
        properties.put("height", 170); //Person class does not have this field

        //Converting map to Person object
        Person person = CustomObjectMapper.toObject(Person.class, properties);

        //Verifying existing fields are correctly set
        assertEquals("suhani", person.getName(), "Name should be 'suhani'");
        assertEquals(20, person.getAge(), "Age should be 20");
    }
}