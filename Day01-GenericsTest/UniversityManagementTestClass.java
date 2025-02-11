package com.capgeminitraining.week4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

class UniversityManagementTest {
    private CourseManagement catalog;
    private Course<ExamCourse> mathExam;
    private Course<AssignmentCourse> literatureAssignment;
    private Course<ResearchCourse> physicsResearch;

    @BeforeEach
    void setUp() {
        catalog = new CourseManagement();

        mathExam = new Course<>("Mathematics", "PCM", new ExamCourse());
        literatureAssignment = new Course<>("English", "Arts", new AssignmentCourse());
        physicsResearch = new Course<>("Physics", "PCB", new ResearchCourse());

        catalog.addCourse(mathExam);
        catalog.addCourse(literatureAssignment);
        catalog.addCourse(physicsResearch);
    }

    @Test
    void testCourse() {
        assertEquals("Mathematics", mathExam.getCourseName());
        assertEquals("PCM", mathExam.getDepartment());
        assertEquals("Exam-Based-Course", mathExam.getCourseType().getName());

        assertEquals("English", literatureAssignment.getCourseName());
        assertEquals("Arts", literatureAssignment.getDepartment());
        assertEquals("Assignment-Based-Course", literatureAssignment.getCourseType().getName());

        assertEquals("Physics", physicsResearch.getCourseName());
        assertEquals("PCB", physicsResearch.getDepartment());
        assertEquals("Research-Based-Course", physicsResearch.getCourseType().getName());
    }


}