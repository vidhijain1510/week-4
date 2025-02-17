package com.capgeminitraining.week4.day6annotationsreflection.annotations.exercisequestion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME) //Retained at runtime for reflection
@Target(ElementType.METHOD) //Can only be applied to methods
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void completeReport() {
        System.out.println("Completing the report...");
    }

    @TaskInfo(priority = "Medium", assignedTo = "Bob")
    public void reviewCode() {
        System.out.println("Reviewing the code...");
    }
}



public class AnnotationProcessor {
    public static void main(String[] args) {
        Class<TaskManager> clazz = TaskManager.class;
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
                System.out.println("----------------------");
            }
        }
    }
}
