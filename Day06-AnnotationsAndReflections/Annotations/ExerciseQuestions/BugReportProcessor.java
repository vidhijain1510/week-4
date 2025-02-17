package com.capgeminitraining.week4.day6annotationsreflection.annotations.exercisequestion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Method;

// Define the container annotation FIRST
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Define the repeatable annotation AFTER the container
@Repeatable(BugReports.class) // Links this annotation to BugReports
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReport {
    String description();
}

class SoftwareModule {

    @BugReport(description = "NullPointerException occurs when input is null.")
    @BugReport(description = "Performance issue when processing large data sets.")
    public void processData() {
        System.out.println("Processing data...");
    }
}


public class BugReportProcessor {
    public static void main(String[] args) {
        Class<SoftwareModule> clazz = SoftwareModule.class;
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(BugReports.class)) { // Use BugReports, not BugReport
                BugReports bugReports = method.getAnnotation(BugReports.class);

                System.out.println("Method: " + method.getName());
                for (BugReport bugReport : bugReports.value()) {
                    System.out.println("Bug Report: " + bugReport.description());
                }
                System.out.println("----------------------");
            }
        }
    }
}
