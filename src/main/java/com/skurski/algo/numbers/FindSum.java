package com.skurski.algo.numbers;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
public class FindSum {

//    public int[] ofDistinct(Integer[] array, int sum) {
//        if (array.length < 2) return null;
//
//        int[] ofDistinct = new int[2];
//
//        Map<Integer, Integer> mapValues = Arrays
//                .stream(array)
//                .collect(Collectors.toMap(val -> val, val -> val));
//
//        for (int i = 0; i < array.length; i++) {
//            int val = array[i];
//            int secondVal = sum - val;
//            if (mapValues.get(secondVal) != null) {
//                ofDistinct[0] = val;
//                ofDistinct[1] = secondVal;
//            }
//        }
//
//        return ofDistinct;
//    }


    public static void main(String[] args) {

        Integer[] result = new FindSum().ofDistinct(new Integer[]{1, 3, 5, 7}, 12);
        System.out.println(Arrays.toString(result));

        for (int i = 0, j = 10; i < j; i++, j--) {
            System.out.println("Print me 5 times");
        }
    }

    /* I'm assuming that all elements are distinct */
    public Integer[] ofDistinct(Integer[] array, Integer sum) {
        if (array.length < 2) {
            return null;
        }

        Integer[] tuples = new Integer[2];
        Map<Integer, Integer> remaining = Arrays.stream(array)
                .collect(Collectors.toMap(Function.identity(), Function.identity()));

        for (int i = 0; i < array.length; i++) {
            int firstFromPair = array[i];
            int requiredSecondFromPair = sum - firstFromPair;
            if (remaining.get(requiredSecondFromPair) != null) {
                tuples[0] = firstFromPair;
                tuples[1] = requiredSecondFromPair;

                return tuples;
            }
        }

        return null;
    }

    /* I'm assuming that elements might occur multiple times */
    public Integer[] of(Integer[] array, Integer sum) {
        if (array.length < 2) {
            return null;
        }

        Integer[] tuples = new Integer[2];
        Map<Integer, Integer> remaining = Arrays.stream(array)
                .collect(Collectors.toMap(Function.identity(), Function.identity()));

        for (int i = 0; i < array.length; i++) {
            int firstFromPair = array[i];
            int requiredSecondFromPair = sum - firstFromPair;
            if (remaining.get(requiredSecondFromPair) != null) {
                tuples[0] = firstFromPair;
                tuples[1] = requiredSecondFromPair;

                return tuples;
            }
        }

        return null;
    }
}
