/*Multi-Level University Course Management System
Concepts: Generic Classes, Wildcards, Bounded Type Parameters
Problem Statement:
Develop a university course management system where different departments offer courses with different evaluation types (e.g., Exam-Based, Assignment-Based, Research-Based).
Hints:
Create an abstract class CourseType (e.g., ExamCourse, AssignmentCourse, ResearchCourse).
Implement a generic class Course<T extends CourseType> to manage different courses.
Use wildcards (List<? extends CourseType>) to handle any type of course dynamically.*/

package com.capgeminitraining.week4;

import java.util.ArrayList;
import java.util.List;

//Abstract super class representing different course types
abstract class CourseType {
    private String name;

    public CourseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

//Courses types classes extending CourseType class
class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based-Course");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based-Course");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based-Course");
    }
}

//Generic class to represent a Course
class Course<T extends CourseType> {
    private String courseName;
    private String department;
    private T courseType;

    public Course(String courseName, String department, T courseType) {
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartment() {
        return department;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return courseName + " (" + department + ") - " + courseType.getName();
    }
}

//Course Management to manage different courses
class CourseManagement {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    public void showCourses() {
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
        }
    }
}

//Main class
public class UniversityManagement {
    public static void main(String[] args) {
        CourseManagement catalog = new CourseManagement();

        //Creating different courses
        Course<ExamCourse> mathExam = new Course<>("Mathematics", "PCM", new ExamCourse());
        Course<AssignmentCourse> literatureAssignment = new Course<>("English", "Arts", new AssignmentCourse());
        Course<ResearchCourse> physicsResearch = new Course<>("Physics", "PCB", new ResearchCourse());

        //Adding courses to the catalog
        catalog.addCourse(mathExam);
        catalog.addCourse(literatureAssignment);
        catalog.addCourse(physicsResearch);

        //Displaying all courses
        System.out.println("Available Courses:");
        catalog.showCourses();
    }
}
