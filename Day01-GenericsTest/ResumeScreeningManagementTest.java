package com.capgeminitraining.week4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class ResumeScreeningManagementTest {
    private ResumeScreeningSystem system;
    private Resume<SoftwareEngineer> softwareEngResume;
    private Resume<DataScientist> dataScientistResume;
    private Resume<ProductManager> productManagerResume;

    @BeforeEach
    void setUp() {
        system = new ResumeScreeningSystem();

        softwareEngResume = new Resume<>(
                "Alice Johnson", 5, new SoftwareEngineer(), List.of("Java", "Spring", "Docker")
        );

        dataScientistResume = new Resume<>(
                "Bob Smith", 3, new DataScientist(), List.of("Python", "Machine Learning", "SQL")
        );

        productManagerResume = new Resume<>(
                "Charlie Brown", 7, new ProductManager(), List.of("Agile", "Roadmap Planning", "Stakeholder Management")
        );

        system.addResume(softwareEngResume);
        system.addResume(dataScientistResume);
        system.addResume(productManagerResume);
    }

    @Test
    void testResumeCreation() {
        assertEquals("Alice Johnson", softwareEngResume.getCandidateName());
        assertEquals(5, softwareEngResume.getYearsOfExperience());
        assertEquals("Software Engineer", softwareEngResume.getJobRole().getRoleName());
        assertEquals(List.of("Java", "Spring", "Docker"), softwareEngResume.getSkills());

        assertEquals("Bob Smith", dataScientistResume.getCandidateName());
        assertEquals(3, dataScientistResume.getYearsOfExperience());
        assertEquals("Data Scientist", dataScientistResume.getJobRole().getRoleName());
        assertEquals(List.of("Python", "Machine Learning", "SQL"), dataScientistResume.getSkills());

        assertEquals("Charlie Brown", productManagerResume.getCandidateName());
        assertEquals(7, productManagerResume.getYearsOfExperience());
        assertEquals("Product Manager", productManagerResume.getJobRole().getRoleName());
        assertEquals(List.of("Agile", "Roadmap Planning", "Stakeholder Management"), productManagerResume.getSkills());
    }

    @Test
    void testAddResumeToScreeningSystem() {
        // Checking the number of resumes in the system
        assertEquals(3, system.getResumeList().size());
    }

    @Test
    void testProcessResume() {
        // Check if the method runs without errors
        assertDoesNotThrow(() -> ResumeScreeningSystem.processResume(softwareEngResume));
        assertDoesNotThrow(() -> ResumeScreeningSystem.processResume(dataScientistResume));
        assertDoesNotThrow(() -> ResumeScreeningSystem.processResume(productManagerResume));
    }
}