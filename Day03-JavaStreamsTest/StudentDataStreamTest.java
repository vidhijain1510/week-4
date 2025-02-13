package com.capgeminitraining.week4.day3javastreams;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

class StudentDataStreamTest {

    private static final String FILE_PATH = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\test\\resources\\testStudentData.txt";

    @BeforeEach
    void setUp() throws IOException {
        //Creating some student objects to store in the binary file
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vidhi", 3.8));
        students.add(new Student(2, "Kapil", 3.5));
        students.add(new Student(3, "Mohit", 2.8));

        //Storing student details in the binary file before each test
        StudentDataStream.storeStudentDetails(FILE_PATH, students);
    }

    @Test
    void testStoreAndRetrieveStudentDetails() throws IOException {
        List<Student> retrievedStudents = StudentDataStream.retrieveStudentDetails(FILE_PATH);
        assertEquals(3, retrievedStudents.size());

        assertEquals(1, retrievedStudents.get(0).getRollNumber());
        assertEquals("Vidhi", retrievedStudents.get(0).getName());
        assertEquals(3.8, retrievedStudents.get(0).getGPA());

        assertEquals(2, retrievedStudents.get(1).getRollNumber());
        assertEquals("Kapil", retrievedStudents.get(1).getName());
        assertEquals(3.5, retrievedStudents.get(1).getGPA());

        assertEquals(3, retrievedStudents.get(2).getRollNumber());
        assertEquals("Mohit", retrievedStudents.get(2).getName());
        assertEquals(2.8, retrievedStudents.get(2).getGPA());
    }
}