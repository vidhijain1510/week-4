/* Generate a JSON Representation: Write a program that converts an object to a JSON-like string using Reflection by inspecting its fields and values.*/
package com.capgeminitraining.week4.day6annotationsreflection.reflections.advancedlevel;

import java.lang.reflect.Field;
import java.util.StringJoiner;

class JsonSerializer {
    public static String toJson(Object obj) {
        if (obj == null) return "null";

        Class<?> clazz = obj.getClass();
        StringJoiner json = new StringJoiner(", ", "{", "}");

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                json.add("\"" + field.getName() + "\": " + formatValue(value));
            } catch (IllegalAccessException e) {
                json.add("\"" + field.getName() + "\": \"<inaccessible>\"");
            }
        }
        return json.toString();
    }

    private static String formatValue(Object value) {
        if (value instanceof String) {
            return "\"" + value + "\"";
        }
        if (value instanceof Boolean || value instanceof Number) {
            return value.toString(); // Convert numbers and booleans directly
        }
        return (value != null) ? "\"" + value.toString() + "\"" : "null";
    }
}

class Person1 {
    private String name;
    private int age;
    private boolean isActive;

    public Person1(String name, int age, boolean isActive) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }
}
public class JsonSerializers {
    public static void main(String[] args) {
        Person1 person = new Person1("Vidhi", 21, true);

        //Converting object to JSON string
        String json = JsonSerializer.toJson(person);

        System.out.println(json);
    }
}


