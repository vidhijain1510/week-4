/*Union and Intersection of Two Sets
Given two sets, compute their union and intersection.
Example:
Set1: {1, 2, 3}, Set2: {3, 4, 5} → Union: {1, 2, 3, 4, 5}, Intersection: {3}.*/

package com.capgeminitraining.week4.day2.SetInterface;

import java.util.Set;
import java.util.HashSet;

public class SetOperations {

    //Method for union of two sets
    public static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> unionSet = new HashSet<>(set1);  //Copy set1
        unionSet.addAll(set2);  //Adding all elements of set2
        return unionSet;
    }

    //Method for intersection of two sets
    public static Set<Integer> getIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersectionSet = new HashSet<>(set1);  //Copy set1
        intersectionSet.retainAll(set2);  //Keeping only common elements
        return intersectionSet;
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

        //union and intersection
        Set<Integer> unionResult = getUnion(set1, set2);
        Set<Integer> intersectionResult = getIntersection(set1, set2);

        System.out.println("Union: " + unionResult);
        System.out.println("Intersection: " + intersectionResult);
    }
}

