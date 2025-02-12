/*Find Subsets
Check if one set is a subset of another.
Example:
Set1: {2, 3}, Set2: {1, 2, 3, 4} → Output: true.*/

package com.capgeminitraining.week4.day2.SetInterface;

import java.util.Set;
import java.util.HashSet;

public class SubsetChecker {

    //Method to check if set1 is a subset of set2
    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2) {
        return set2.containsAll(set1); //Checking if all elements of set1 exist in set2
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        //Adding elements
        set1.add(2);
        set1.add(3);

        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        //Checking if set1 is a subset of set2
        boolean result = isSubset(set1, set2);
        System.out.println("Is set1 a subset of set2? " + result);
    }
}

