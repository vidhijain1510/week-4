/*Create a Custom Object Mapper: Implement a method toObject(Class<T> clazz, Map<String, Object> properties) that uses Reflection to set field values from a given Map.*/
package com.capgeminitraining.week4.day6annotationsreflection.reflections.advancedlevel;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;

public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            //Creating a new instance of the class
            T instance = clazz.getDeclaredConstructor().newInstance();

            //Iterating through each property in the map
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                try {
                    //Getting the field from the class
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true); //Allowing modification of private fields

                    //Setting the field value
                    field.set(instance, fieldValue);
                } catch (NoSuchFieldException e) {
                    //If a field doesn't exist, skip it
                    System.out.println("Field not found: " + fieldName);
                }
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to map properties to object", e);
        }
    }
}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class ObjectMapperTest {
    public static void main(String[] args) {
        //Creating a properties map
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "Vidhi");
        properties.put("age", 21);

        //Converting map to object
        Person person = CustomObjectMapper.toObject(Person.class, properties);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}

