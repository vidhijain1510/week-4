/*Invert a Map
Invert a Map<K, V> to produce a Map<V, K>. Handle duplicate values by storing them in a list.
Example:
Input: {A=1, B=2, C=1} → Output: {1=[A, C], 2=[B]}.*/
package com.capgeminitraining.week4.day2.MapInterface;

import java.util.*;

public class MapInvert {
    public static void main(String[] args) {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);

        Map<Integer, List<String>> invertedMap = invertMap(inputMap);

        System.out.println(invertedMap);
    }

    //Method to invert a Map with generics
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        //Iterating over each entry in the original map
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            //If the value doesn't exist in the inverted map, create a new list for it
            invertedMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                    .add(entry.getKey());
        }
        return invertedMap;
    }
}

