/*4️⃣ Create a @MaxLength Annotation for Field Validation
✅ Problem Statement:
Define a field-level annotation @MaxLength(int value) that restricts the maximum length of a String field.
🔹 Requirements:
Apply it to a User class field (username).
Validate length in the constructor.
Throw IllegalArgumentException if the limit is exceeded.*/
package com.capgeminitraining.week4.day6annotationsreflection.annotations.intermediatelevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

//Defining @MaxLength annotation
@Retention(RetentionPolicy.RUNTIME) //Available at runtime for reflection
@Target(ElementType.FIELD) //Can only be applied to fields
@interface MaxLength {
    int value(); //Maximum length constraint
}



class User {

    @MaxLength(10) //Restrict username to max 10 characters
    private String username;

    public User(String username) {
        validateMaxLength(this, username);
        this.username = username;
    }

    private void validateMaxLength(Object obj, String fieldValue) {
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (fieldValue.length() > maxLength.value()) {
                    throw new IllegalArgumentException(
                            "Field '" + field.getName() + "' exceeds max length of " + maxLength.value()
                    );
                }
            }
        }
    }

    public String getUsername() {
        return username;
    }
}

public class MaxLengthAnnotation {
    public static void main(String[] args) {
        try {
            User user1 = new User("JohnDoe");
            System.out.println("Created user: " + user1.getUsername());

            User user2 = new User("VeryLongUsername"); //This should throw an exception
            System.out.println("Created user: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}



