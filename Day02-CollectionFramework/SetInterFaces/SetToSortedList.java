/*Convert a Set to a Sorted List
Convert a HashSet of integers into a sorted list in ascending order.
Example:
Input: {5, 3, 9, 1} → Output: [1, 3, 5, 9].*/
package com.capgeminitraining.week4.day2.SetInterface;

import java.util.*;

public class SetToSortedList {
    //Method to convert a set to a sorted list
    public static List<Integer> convertSetToSortedList(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set); //Converting set to list
        Collections.sort(sortedList); //Sorting list in ascending order
        return sortedList;
    }

    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();

        //Adding elements
        hashSet.add(5);
        hashSet.add(3);
        hashSet.add(9);
        hashSet.add(1);

        //Converting to sorted list
        List<Integer> sortedList = convertSetToSortedList(hashSet);
        System.out.println("Sorted List: " + sortedList);
    }
}