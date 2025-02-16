/*2️⃣ Create a @Todo Annotation for Pending Tasks
✅ Problem Statement:
Define an annotation @Todo to mark pending features in a project.
🔹 Requirements:
The annotation should have fields:
task() (String) → Description of the task
assignedTo() (String) → Developer responsible
priority() (default: "MEDIUM")
Apply it to multiple methods.
Retrieve and print all pending tasks using Reflection.*/
package com.capgeminitraining.week4.day6annotationsreflection.annotations.beginnerlevel;


import java.lang.reflect.Method;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Defining @Todo annotation with task details
@Retention(RetentionPolicy.RUNTIME) //Available at runtime for reflection
@Target(ElementType.METHOD) //Can be applied to methods
@interface Todo {
    String task(); //Task description
    String assignedTo(); //Developer responsible
    String priority() default "MEDIUM"; //
    // Default priority
}

class FeatureDevelopment {

    @Todo(task = "Implement user authentication", assignedTo = "Vidhi", priority = "HIGH")
    public void implementAuth() {
        System.out.println("Authentication implementation pending...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Suhani")
    public void optimizeDB() {
        System.out.println("Database optimization pending...");
    }

    @Todo(task = "Write unit tests for payment module", assignedTo = "Shreasth", priority = "LOW")
    public void testPayments() {
        System.out.println("Payment module tests pending...");
    }
}

public class TodoProcessor {
    public static void main(String[] args) {
        processTodos(FeatureDevelopment.class);
    }

    public static void processTodos(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("TODO: " + todo.task() +
                        " | Assigned To: " + todo.assignedTo() +
                        " | Priority: " + todo.priority() +
                        " | Method: " + method.getName());
            }
        }
    }
}

