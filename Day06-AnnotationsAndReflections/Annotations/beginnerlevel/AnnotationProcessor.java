/*1️⃣ Create an Annotation to Mark Important Methods
✅ Problem Statement:
Define a custom annotation @ImportantMethod that can be applied to methods to indicate their importance.
🔹 Requirements:
Define @ImportantMethod with an optional level parameter (default: "HIGH").
Apply it to at least two methods.
Retrieve and print annotated methods using Reflection API.*/
package com.capgeminitraining.week4.day6annotationsreflection.annotations.beginnerlevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;


//Defining custom annotation
@Retention(RetentionPolicy.RUNTIME) //Keeping annotation at runtime for reflection
@Target(ElementType.METHOD) //Applying only to methods

@interface ImportantMethod {
    String level() default "HIGH"; //Default level is "HIGH"
}
//class with annotated methods
class TaskProcessor {

    @ImportantMethod(level = "CRITICAL")
    public void processImportantTask() {
        System.out.println("Processing a CRITICAL task...");
    }

    @ImportantMethod //Defaults to level = "HIGH"
    public void processRegularTask() {
        System.out.println("Processing a HIGH importance task...");
    }

    public void normalTask() {
        System.out.println("This is a normal task with no annotation.");
    }
}

public class AnnotationProcessor {
    public static void main(String[] args) {
        processAnnotations(TaskProcessor.class);
    }

    public static void processAnnotations(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + " | Importance Level: " + annotation.level());
            }
        }
    }
}

