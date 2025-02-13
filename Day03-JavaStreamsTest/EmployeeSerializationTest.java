package com.capgeminitraining.week4.day3javastreams;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;



class EmployeeSerializationTest {

    private static final String TEST_FILE_NAME = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\test\\resources\\employees.ser";

    @BeforeEach
    void setUp() {
        File file = new File(TEST_FILE_NAME);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testSaveEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "IT", 75000));
        employees.add(new Employee(2, "Jane Smith", "HR", 68000));

        EmployeeSerialization.saveEmployees(employees);

        File file = new File(TEST_FILE_NAME);
        assertTrue(file.exists(), "Serialized file should exist.");

        List<Employee> loadedEmployees = EmployeeSerialization.loadEmployees();
        assertEquals(2, loadedEmployees.size(), "The number of employees should be 2.");
    }

    @Test
    void testLoadEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "IT", 75000));
        employees.add(new Employee(2, "Jane Smith", "HR", 68000));

        EmployeeSerialization.saveEmployees(employees);

        List<Employee> loadedEmployees = EmployeeSerialization.loadEmployees();

        assertNotNull(loadedEmployees, "Loaded employees should not be null.");
        assertEquals(2, loadedEmployees.size(), "The number of loaded employees should be 2.");
        assertEquals("John Doe", loadedEmployees.get(0).toString(), "First employee name should be John Doe.");
        assertEquals("Jane Smith", loadedEmployees.get(1).toString(), "Second employee name should be Jane Smith.");
    }

    @Test
    void testFileNotFoundOnLoad() {

        List<Employee> loadedEmployees = EmployeeSerialization.loadEmployees();

        assertTrue(loadedEmployees.isEmpty(), "Loaded employees should be empty when the file is not found.");
    }

    @Test
    void testSaveAndLoadWithEmptyList() {
        List<Employee> emptyList = new ArrayList<>();

        EmployeeSerialization.saveEmployees(emptyList);

        List<Employee> loadedEmployees = EmployeeSerialization.loadEmployees();

        assertTrue(loadedEmployees.isEmpty(), "Loaded employees should be empty.");
    }

    @AfterEach
    void tearDown() {
        File file = new File(TEST_FILE_NAME);
        if (file.exists()) {
            file.delete();
        }
    }
}