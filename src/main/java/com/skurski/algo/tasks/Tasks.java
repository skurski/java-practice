package com.skurski.algo.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class Tasks {

    /*
        Write a function that, given a list and a target sum,
        returns zero-based indices of any two distinct elements
        whose sum is equal to the target sum. If there are
        no such elements, the function should return null.

        For example, findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12)
        should return any of the following ofDistinct of indices:

        1, 4 (3 + 9 = 12)
        2, 3 (5 + 7 = 12)
        3, 2 (7 + 5 = 12)
        4, 1 (9 + 3 = 12)
    */
    public static Map<Integer, Integer> findTwoSum(int[] table, int sum) {
        Map<Integer, Integer> tuple = new HashMap<>(2);

        Set<Integer> elements = Arrays.stream(table)
                .collect(HashSet::new, (set, e) -> set.add(e), (s1, s2) -> s1.addAll(s2));

        // JAVA 8 STREAMS APPROACH, returns empty map if not present
        Arrays.stream(table)
                .filter(elem -> elements.contains(sum - elem))
                .findFirst().ifPresent(elem -> tuple.put(elem, sum - elem));

        return tuple;

//        // CLASSIC APPROACH
//        for (int i = 0; i < table.length; i++) {
//            int element = table[i];
//            int remainder = sum - table[i];
//
//            if (elements.contains(remainder)) {
//                tuple.put(element, remainder);
//                return tuple;
//            }
//        }
//
//        return null;
    }

    public static void main(String[] args) {
        int[] table = new int[]{1, 3, 1, 7, 1};
        Map<Integer, Integer> result = findTwoSum(table, 12);

        result.forEach((k, v) -> System.out.println("Tuple is: " + k + ", " + v));
    }
}
