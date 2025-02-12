package com.capgeminitraining.week4.day2.MapInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collectors;

public class GroupEmployeesByDepartmentTest {

    @Test
    public void testGroupEmployeesByDepartment() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", Department.HR),
                new Employee("Bob", Department.IT),
                new Employee("Carol", Department.HR)
        );
        Map<Department, List<Employee>> groupedByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        assertEquals(2, groupedByDepartment.size());

        //HR department
        List<Employee> hrEmployees = groupedByDepartment.get(Department.HR);
        assertNotNull(hrEmployees);
        assertEquals(2, hrEmployees.size());
        assertTrue(hrEmployees.stream().anyMatch(emp -> emp.getName().equals("Alice")));
        assertTrue(hrEmployees.stream().anyMatch(emp -> emp.getName().equals("Carol")));

        //IT department
        List<Employee> itEmployees = groupedByDepartment.get(Department.IT);
        assertNotNull(itEmployees );
        assertEquals(1, itEmployees.size());
        assertTrue(itEmployees.stream().anyMatch(emp -> emp.getName().equals("Bob")));
    }
}
