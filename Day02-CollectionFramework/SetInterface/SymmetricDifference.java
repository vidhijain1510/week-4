/*Symmetric Difference
Find the symmetric difference (elements present in either set but not in both) of two sets.
Example:
Set1: {1, 2, 3}, Set2: {3, 4, 5} → Output: {1, 2, 4, 5}.*/

package com.capgeminitraining.week4.day2.SetInterface;

import java.util.Set;
import java.util.HashSet;

public class SymmetricDifference {

    //Method to compute symmetric difference
    public static Set<Integer> getSymmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> symmetricDiff = new HashSet<>(set1); //set1
        Set<Integer> temp = new HashSet<>(set2); //set2

        symmetricDiff.removeAll(set2); //Removing common elements from set1
        temp.removeAll(set1); //Removing common elements from set2

        symmetricDiff.addAll(temp); //Combining unique elements
        return symmetricDiff;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        //Adding elements
        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> result = getSymmetricDifference(set1, set2);
        System.out.println("Symmetric Difference: " + result);
    }
}
