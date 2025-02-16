/*Access and Modify Static Fields: Create a Configuration class with a private static field API_KEY. Use Reflection to modify its value and print it.*/
package com.capgeminitraining.week4.day6annotationsreflection.reflections.intermediatelevel;

import java.lang.reflect.Field;

public class ModifyStaticField {
    public static void main(String[] args) {
        try {
            //Getting the Class object
            Class<?> configClass = Configuration.class;

            //Getting the private static field API_KEY
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            //Making it accessible for modification
            apiKeyField.setAccessible(true);

            //Modifying the static field
            apiKeyField.set(null, "NEW_SECRET_KEY");
            System.out.println("Updated API_KEY: " + Configuration.getApiKey());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Configuration {
    private static String API_KEY = "DEFAULT_KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}
