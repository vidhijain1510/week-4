/*3️⃣ Testing List Operations
Problem:
Create a ListManager class that has the following methods:
addElement(List<Integer> list, int element): Adds an element to a list.
removeElement(List<Integer> list, int element): Removes an element from a list.
getSize(List<Integer> list): Returns the size of the list.
Write JUnit tests to verify that:
✅ Elements are correctly added.
✅ Elements are correctly removed.
✅ The size of the list is updated correctly.
*/
package com.capgeminitraining.week4.day5regexjunit.junit;


import java.util.List;

public class ListManager {

    //Method to add an element to the list
    public static void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    //Method to remove an element from the list
    public static boolean removeElement(List<Integer> list, int element) {
        return list.remove(Integer.valueOf(element)); // Removes by value, not index
    }

    //Method to get the size of the list
    public static int getSize(List<Integer> list) {
        return list.size();
    }
}
