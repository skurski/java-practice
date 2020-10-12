package com.skurski.algo.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RodCutting {

    public static int[] solution(int[] length, int[] value, int sum) {
        Map<Integer, Integer> valuesMap = new HashMap<>();

        for (int i = 0; i < length.length; i++) {
            valuesMap.put(length[i], value[i]);
        }

        int maxValue = 0;
        int[] result = new int[2];
        for (int i = 0; i < length.length; i++) {
            int complementary = sum - length[i];
            int checkPair = valuesMap.get(length[i]).intValue()
                    + valuesMap.get(complementary).intValue();

            if (maxValue < checkPair) {
                maxValue = checkPair;
                result[0] = length[i];
                result[1] = complementary;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] pair = solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                              new int[]{1, 5, 8, 9, 10, 17, 17, 20, 20}, 10);

        System.out.println(Arrays.toString(pair));
    }
}
