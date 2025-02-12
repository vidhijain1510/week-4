package com.capgeminitraining.week4.day2.MapInterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

class InsurancePolicyManagerTest {

    private InsurancePolicyManager manager;

    @BeforeEach
    void setUp() {
        manager = new InsurancePolicyManager();
        manager.addPolicy(new Policy("P123", "John Doe", LocalDate.of(2025, 3, 15)));
        manager.addPolicy(new Policy("P124", "Jane Smith", LocalDate.of(2025, 2, 20)));
        manager.addPolicy(new Policy("P125", "John Doe", LocalDate.of(2025, 5, 10)));
    }

    @Test
    void testAddPolicy() {
        manager.addPolicy(new Policy("P126", "Alice Brown", LocalDate.of(2025, 6, 25)));
        Policy policy = manager.getPolicyByNumber("P126");
        assertNotNull(policy);
        assertEquals("Alice Brown", policy.getPolicyholderName());
        assertEquals(LocalDate.of(2025, 6, 25), policy.getExpiryDate());
    }

    @Test
    void testGetPolicyByNumber() {
        Policy policy = manager.getPolicyByNumber("P123");
        assertNotNull(policy);
        assertEquals("John Doe", policy.getPolicyholderName());
        assertEquals(LocalDate.of(2025, 3, 15), policy.getExpiryDate());
    }

    @Test
    void testListPoliciesExpiringSoon() {
        List<Policy> expiringPolicies = manager.listPoliciesExpiringSoon();
        assertEquals(1, expiringPolicies.size());
        assertEquals("P124", expiringPolicies.get(0).getPolicyNumber());
    }

    @Test
    void testListPoliciesByPolicyholder() {
        List<Policy> johnPolicies = manager.listPoliciesByPolicyholder("John Doe");
        assertEquals(2, johnPolicies.size());
        assertTrue(johnPolicies.stream().anyMatch(policy -> policy.getPolicyNumber().equals("P123")));
        assertTrue(johnPolicies.stream().anyMatch(policy -> policy.getPolicyNumber().equals("P125")));
    }




}