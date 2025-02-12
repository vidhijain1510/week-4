/*Group Objects by Property
Given a list of Employee objects, group them by their department using a Map<Department, List<Employee>>.
Example:
Employees: [Alice (HR), Bob (IT), Carol (HR)] → Output: HR: [Alice, Carol], IT: [Bob].*/
package com.capgeminitraining.week4.day2.MapInterface;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }
    public String getName() {
        return name;
    }
    public Department getDepartment() {
        return department;
    }
    @Override
    public String toString() {
        return name;
    }
}
enum Department {
    HR, IT, FINANCE, SALES
}

public class GroupEmployeesByDepartment {
    public static void main(String[] args) {
        //List of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", Department.HR),
                new Employee("Bob", Department.IT),
                new Employee("Carol", Department.HR)
        );

        //Group employees by their department
        Map<Department, List<Employee>> groupedByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        //Output grouped map
        groupedByDepartment.forEach((department, employeeList) -> {
            System.out.println(department + ": " + employeeList);
        });
    }
}
