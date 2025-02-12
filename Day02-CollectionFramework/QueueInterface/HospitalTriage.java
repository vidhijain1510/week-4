/*Hospital Triage System
Simulate a hospital triage system using a PriorityQueue where patients with higher severity are treated first.
Example:
Patients: [("John", 3), ("Alice", 5), ("Bob", 2)] → Order: Alice, John, Bob.*/
package com.capgeminitraining.week4.day2.QueueInterface;

import java.util.PriorityQueue;
import java.util.Comparator;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        //PriorityQueue with custom comparator to sort by severity (higher first)
        PriorityQueue<Patient> queue = new PriorityQueue<>(Comparator.comparingInt((Patient p) -> -p.severity));

        //Adding patients
        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        //Processing patients in order of severity
        System.out.println("Order of treatment:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
