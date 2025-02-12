/*Insurance Policy Management System

Build a system for managing insurance policies where you have to:
Store and manage policies with unique identifiers.
Retrieve and manipulate policies based on different criteria.
Track policies by various attributes such as policyholder name and expiry date.

Requirements:
1. Store Policies in a Map:
Use HashMap to store policies with policy numbers as keys and policy
details as values.
Use LinkedHashMap to maintain the insertion order of policies.
Use TreeMap to store policies sorted by expiry date.

2. Retrieve and Manipulate Policies:
Implement methods to:
Retrieve a policy by its number.
List all policies expiring within the next 30 days.
List all policies for a specific policyholder.
Remove policies that are expired.
*/
package com.capgeminitraining.week4.day2.MapInterface;

import java.time.LocalDate;
import java.util.*;

class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Policyholder: " + policyholderName + ", Expiry Date: " + expiryDate;
    }
}



public class InsurancePolicyManager {
    private Map<String, Policy> policyMap;           //Storing policies with policy number as key (HashMap)
    private Map<String, Policy> linkedPolicyMap;    //Storing policies maintaining insertion order (LinkedHashMap)
    private List<Policy> sortedPolicyList;          //Storing policies in a list to sort by expiry date

    public InsurancePolicyManager() {
        policyMap = new HashMap<>();
        linkedPolicyMap = new LinkedHashMap<>();
        sortedPolicyList = new ArrayList<>();
    }

    //Adding a new policy
    public void addPolicy(Policy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        linkedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedPolicyList.add(policy);  // Add to the list for sorting by expiry date
        sortPoliciesByExpiryDate();   // Sort after adding
    }

    //Sorting policies by expiry date
    public void sortPoliciesByExpiryDate() {
        sortedPolicyList.sort(Comparator.comparing(Policy::getExpiryDate));
    }

    //Retrieving a policy by its number
    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    //List policies expiring within the next 30 days
    public List<Policy> listPoliciesExpiringSoon() {
        List<Policy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);

        for (Policy policy : policyMap.values()) {
            if (!policy.getExpiryDate().isBefore(today) && policy.getExpiryDate().isBefore(thirtyDaysLater)) {
                expiringPolicies.add(policy);
            }
        }
        return expiringPolicies;
    }

    //List all policies for a specific policyholder
    public List<Policy> listPoliciesByPolicyholder(String policyholderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.getPolicyholderName().equals(policyholderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    //Removing expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<String, Policy>> iterator = policyMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Policy> entry = iterator.next();
            if (entry.getValue().getExpiryDate().isBefore(today)) {
                iterator.remove();
            }
        }
    }

    //Displaying all sorted policies
    public void displaySortedPolicies() {
        for (Policy policy : sortedPolicyList) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        //Adding sample policies
        manager.addPolicy(new Policy("P123", "John Doe", LocalDate.of(2025, 3, 15)));
        manager.addPolicy(new Policy("P124", "Jane Smith", LocalDate.of(2025, 2, 20)));
        manager.addPolicy(new Policy("P125", "John Doe", LocalDate.of(2025, 5, 10)));

        //Displaying sorted policies by expiry date
        System.out.println("Policies sorted by expiry date:");
        manager.displaySortedPolicies();
    }
}
