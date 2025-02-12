package com.capgeminitraining.week4.day2.SetInterface;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;


public class InsurancePolicyManagerTest {
    private com.capgeminitraining.week4.day2.SetInterface.InsurancePolicyManager manager;
    private com.capgeminitraining.week4.day2.SetInterface.Policy policy1, policy2, policy3;
    private SimpleDateFormat dateFormat;

    @BeforeEach
    public void setUp() throws Exception {
        manager = new com.capgeminitraining.week4.day2.SetInterface.InsurancePolicyManager();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date expiry1 = dateFormat.parse("2025-03-01");
        Date expiry2 = dateFormat.parse("2025-02-20");
        Date expiry3 = dateFormat.parse("2025-05-10");

        policy1 = new com.capgeminitraining.week4.day2.SetInterface.Policy("P1001", "Alice", expiry1, "Health", 500);
        policy2 = new com.capgeminitraining.week4.day2.SetInterface.Policy("P1002", "Bob", expiry2, "Auto", 300);
        policy3 = new com.capgeminitraining.week4.day2.SetInterface.Policy("P1003", "Charlie", expiry3, "Home", 400);

        // Add policies to the manager
        manager.addPolicy(policy1);
        manager.addPolicy(policy2);
        manager.addPolicy(policy3);
    }



    @Test
    public void testDisplayAllPolicies() {
        // Capture the output using System.out
        manager.displayAllPolicies();
        // Manually verify the printed output or refactor to return a collection for easier testing
    }

    @Test
    public void testDisplayPoliciesExpiringSoon() {
        manager.displayPoliciesExpiringSoon();
        // Manually verify the printed output to check which policies expire soon.
    }

    @Test
    public void testDisplayPoliciesByCoverage() {
        manager.displayPoliciesByCoverage("Health");
        // Manually verify the printed output for policies with "Health" coverage.
    }

    @Test
    public void testDisplayDuplicatePolicies() {
        manager.addPolicy(new com.capgeminitraining.week4.day2.SetInterface.Policy("P1001", "Alice", policy1.getExpiryDate(), "Health", 500));  // Adding a duplicate
        manager.displayDuplicatePolicies();
        // Manually verify the output to check that duplicates are detected.
    }




    @Test
    public void testComparePerformance() {
        long startTime = System.nanoTime();
        manager.comparePerformance();
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        assertTrue(duration > 0, "Performance comparison should have a non-zero execution time.");
    }


}