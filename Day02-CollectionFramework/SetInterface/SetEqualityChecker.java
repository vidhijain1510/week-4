/*Check if Two Sets Are Equal
Compare two sets and determine if they contain the same elements, regardless of order.
Example:
Set1: {1, 2, 3}, Set2: {3, 2, 1} → Output: true.*/

package com.capgeminitraining.week4.day2.SetInterface;

import java.util.Set;
import java.util.HashSet;

public class SetEqualityChecker {

    //Method to check if two sets are equal
    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        return set1.equals(set2);  //Using built-in equals() method
    }

    public static void main(String[] args) {
        //Creating two sets using HashSet
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        //Adding elements to the sets
        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(2);
        set2.add(1);

        //Calling the method to check equality
        boolean result = areSetsEqual(set1, set2);

        System.out.println("Are the sets equal? " + result);
    }
}


