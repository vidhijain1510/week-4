/*Data Streams - Store and Retrieve Primitive Data
📌 Problem Statement:
Write a Java program that stores student details (roll number, name, GPA) in a binary file and retrieves it later.
Requirements:
Use DataOutputStream to write primitive data.
Use DataInputStream to read data.
Ensure proper closing of resources.
*/

package com.capgeminitraining.week4.day3javastreams;

import java.io.*;
import java.util.*;

class Student{
    private int rollNumber;
    private String name;
    private double GPA;

    public Student(int rollNumber, String name, double GPA){
        this.rollNumber = rollNumber;
        this.name = name;
        this.GPA = GPA;
    }

    public int getRollNumber(){
        return rollNumber;
    }

    public String getName(){
        return name;
    }

    public double getGPA(){
        return GPA;
    }

    public String toString(){
        return "Student{" +
                "RollNumber="+rollNumber+
                ", name="+name+
                ", GPA=" +GPA+
                '}';
    }
}

public class StudentDataStream {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\main\\resources\\StudentDetails.txt";

        //Creating some student objects to store
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vidhi", 9.00));
        students.add(new Student(2, "Kapil", 8.88));
        students.add(new Student(3, "Yaman", 8.78));

        //Storing student details in the binary file
        try {
            storeStudentDetails(filePath, students);
            System.out.println("Student details stored successfully.");
        } catch (IOException e) {
            System.out.println("Error storing student details: " + e.getMessage());
        }

        //Retrieving and print student details from the binary file
        try {
            List<Student> retrievedStudents = retrieveStudentDetails(filePath);
            System.out.println("Retrieved student details:");
            retrievedStudents.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error retrieving student details: " + e.getMessage());
        }
    }

    //Method to store student details in a binary file
    public static void storeStudentDetails(String filePath, List<Student> students) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            for (Student student : students) {
                dos.writeInt(student.getRollNumber());
                dos.writeUTF(student.getName());
                dos.writeDouble(student.getGPA());
            }
        }
    }

    //Method to retrieve student details from a binary file
    public static List<Student> retrieveStudentDetails(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                students.add(new Student(rollNumber, name, gpa));
            }
        }
        return students;
    }
}
