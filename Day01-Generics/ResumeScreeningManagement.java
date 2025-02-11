/*AI-Driven Resume Screening System
Concepts: Generic Classes, Generic Methods, Bounded Type Parameters, Wildcards
Problem Statement:
Develop an AI-Driven Resume Screening System that can process resumes for different job roles like Software Engineer, Data Scientist, and Product Manager while ensuring type safety.
Hints:
Create an abstract class JobRole (SoftwareEngineer, DataScientist, ProductManager).
Implement a generic class Resume<T extends JobRole> to process resumes dynamically.
Use a wildcard method (List<? extends JobRole>) to handle multiple job roles in the screening pipeline.*/
package com.capgeminitraining.week4;

import java.util.ArrayList;
import java.util.List;

//Abstract class representing different job roles
abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}

//Concrete job roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

//Generic class to represent a Resume
class Resume<T extends JobRole> {
    private String candidateName;
    private int yearsOfExperience;
    private T jobRole;
    private List<String> skills;

    public Resume(String candidateName, int yearsOfExperience, T jobRole, List<String> skills) {
        this.candidateName = candidateName;
        this.yearsOfExperience = yearsOfExperience;
        this.jobRole = jobRole;
        this.skills = skills;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public T getJobRole() {
        return jobRole;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return candidateName + " - " + jobRole.getRoleName() + " (" + yearsOfExperience + " years) - Skills: " + skills;
    }
}

//Resume Screening System
class ResumeScreeningSystem {
    private List<Resume<? extends JobRole>> resumes = new ArrayList<>();

    public void addResume(Resume<? extends JobRole> resume) {
        resumes.add(resume);
    }

    public void showResumes() {
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println(resume);
        }
    }

    //Generic method to process resumes dynamically
    public static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println("Processing resume of " + resume.getCandidateName() + " for " + resume.getJobRole().getRoleName());
    }
    public List<Resume<? extends JobRole>> getResumeList() {
        return resumes;
    }

}

//Main class
public class ResumeScreeningManagement {
    public static void main(String[] args) {
        ResumeScreeningSystem system = new ResumeScreeningSystem();

        //Creating different resumes
        Resume<SoftwareEngineer> softwareEngResume = new Resume<>(
                "Vidhi Jain", 5, new SoftwareEngineer(), List.of("Java", "Spring", "Docker")
        );

        Resume<DataScientist> dataScientistResume = new Resume<>(
                "Kapil", 3, new DataScientist(), List.of("Python", "Machine Learning", "SQL")
        );

        Resume<ProductManager> productManagerResume = new Resume<>(
                "Pranjal", 7, new ProductManager(), List.of("Agile", "Roadmap Planning", "Stakeholder Management")
        );

        //Adding resumes to the screening system
        system.addResume(softwareEngResume);
        system.addResume(dataScientistResume);
        system.addResume(productManagerResume);

        //Display all resumes
        System.out.println("All Resumes:");
        system.showResumes();

        //Process individual resumes dynamically
        ResumeScreeningSystem.processResume(softwareEngResume);
        ResumeScreeningSystem.processResume(dataScientistResume);
        ResumeScreeningSystem.processResume(productManagerResume);
    }
}
