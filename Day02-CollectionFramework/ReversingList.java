/*Reverse a List
Write a program to reverse the elements of a given List without using built-in reverse methods.
Implement it for both ArrayList and LinkedList.
Example:
Input: [1, 2, 3, 4, 5] → Output: [5, 4, 3, 2, 1].*/

package com.capgeminitraining.week4.day2;

import java.util.*;
public class ReversingList {

    //Reversing an ArrayList without using built-in reverse methods
    public static <T> List<T> reverseArrayList(List<T> list) {
        List<T> reversedList = new ArrayList<>(list.size());
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }

    //Reversing a LinkedList without using built-in reverse methods
    public static <T> List<T> reverseLinkedList(List<T> list) {
        LinkedList<T> reversedList = new LinkedList<>();
        for (T item : list) {
            reversedList.addFirst(item);
        }
        return reversedList;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

        System.out.print("Original ArrayList: " + arrayList);
        System.out.println(" | Reversed ArrayList: " + reverseArrayList(arrayList));

        System.out.print("Original LinkedList: " + linkedList);
        System.out.println(" | Reversed LinkedList: " + reverseLinkedList(linkedList));
    }
}

