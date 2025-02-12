/*Remove Duplicates While Preserving Order
Remove duplicate elements from a list while maintaining the original order of elements.
Example:
Input: [3, 1, 2, 2, 3, 4] → Output: [3, 1, 2, 4].*/

package com.capgeminitraining.week4.day2.ListInterface;

import java.util.*;

public class DuplicateRemove {
    static public<T> List<T> removeDuplicate(List<T> input){
        return new ArrayList<>(new LinkedHashSet<>(input));
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 1, 2, 2, 3, 4);
        System.out.println("Original List: " + input);

        List<Integer> uniqueList = removeDuplicate(input);
        System.out.println("List After Removing Duplicates: " + uniqueList);
    }
}
