/*6️⃣ Implement a Custom Serialization Annotation @JsonField
✅ Problem Statement:
Define an annotation @JsonField to mark fields for JSON serialization.
🔹 Requirements:
@JsonField(name = "user_name") should map field names to custom JSON keys.
Apply it on a User class.
Write a method to convert object to JSON string by reading the annotations.*/
package com.capgeminitraining.week4.day6annotationsreflection.annotations.advancedlevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

//Defining the @JsonField Annotation
@Retention(RetentionPolicy.RUNTIME) //Available at runtime
@Target(ElementType.FIELD) //Can be applied to fields
@interface JsonField {
    String name(); //Custom JSON key name
}

class User1 {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    private String ignoredField; //This field won't be serialized

    public User1(String username, int age, String ignoredField) {
        this.username = username;
        this.age = age;
        this.ignoredField = ignoredField;
    }
}

class JsonSerializer {

    public static String serialize(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            Map<String, String> jsonMap = new HashMap<>();

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true); //Allow access to private fields

                if (field.isAnnotationPresent(JsonField.class)) {
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    jsonMap.put(annotation.name(), field.get(obj).toString());
                }
            }

            return jsonMapToJsonString(jsonMap);
        } catch (Exception e) {
            throw new RuntimeException("Serialization error: " + e.getMessage());
        }
    }

    private static String jsonMapToJsonString(Map<String, String> jsonMap) {
        StringBuilder jsonBuilder = new StringBuilder("{");
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            jsonBuilder.append("\"").append(entry.getKey()).append("\": ")
                    .append("\"").append(entry.getValue()).append("\", ");
        }

        if (jsonBuilder.length() > 1) {
            jsonBuilder.setLength(jsonBuilder.length() - 2); // Remove trailing comma
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}

public class JsonFieldSerialization {
    public static void main(String[] args) {
        User1 user = new User1("Vidhi Jain", 21, "ignoredData");
        String json = JsonSerializer.serialize(user);
        System.out.println("Serialized JSON: " + json);
    }
}

