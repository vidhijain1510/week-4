/*3️⃣ Create an Annotation for Logging Method Execution Time
✅ Problem Statement:
Define an annotation @LogExecutionTime to measure method execution time.
🔹 Requirements:
Apply @LogExecutionTime to a method.
Use System.nanoTime() before and after execution.
Print execution time.
Apply it on different methods and compare the time taken.
*/
package com.capgeminitraining.week4.day6annotationsreflection.annotations.intermediatelevel;

import java.lang.reflect.Method;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Defining @LogExecutionTime annotation
@Retention(RetentionPolicy.RUNTIME) //Retained at runtime for reflection
@Target(ElementType.METHOD) //Can only be applied to methods
@interface LogExecutionTime {
}


class PerformanceTest {

    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Executing fastMethod...");
    }

    @LogExecutionTime
    public void slowMethod() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Executing slowMethod...");
    }

    public void normalMethod() {
        System.out.println("Executing normalMethod (not logged)...");
    }
}



public class ExecutionTimeLogger {
    public static void main(String[] args) throws Exception {
        PerformanceTest testObject = new PerformanceTest();
        logExecutionTime(testObject);
    }

    public static void logExecutionTime(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime(); //Starts measuring
                method.invoke(obj); //Executes method
                long endTime = System.nanoTime(); //Ends measuring

                long executionTime = (endTime - startTime) / 1_000_000; //Converting to milliseconds
                System.out.println("Method " + method.getName() + " executed in " + executionTime + " ms");
            }
        }
    }
}

