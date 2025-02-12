/*Rotate Elements in a List
Rotate the elements of a list by a given number of positions.
Example:
Input: [10, 20, 30, 40, 50], rotate by 2 → Output: [30, 40, 50, 10, 20].*/

package com.capgeminitraining.week4.day2.ListInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateList {
    static public<T> List<T> rotateElement(List<T> input, int k){//k depicts the number of rotation
        int size = input.size();
        k = k % size; //Handles cases where k is larger than the list size

        List<T> rotated = new ArrayList<>();
        rotated.addAll(input.subList(k, size)); //Adding elements from k to end
        rotated.addAll(input.subList(0, k));    //Adding elements from start to k

        return rotated;
    }
    //Main Method
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 20, 30, 40, 50);
        int k = 2;
        List<Integer> rotatedList = rotateElement(input, k);
        System.out.println(rotatedList);
    }
}