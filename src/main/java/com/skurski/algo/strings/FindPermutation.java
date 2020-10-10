package com.skurski.algo.strings;

import java.util.Arrays;

/**
 * Napisz metodę, która przyjmuje dwa łańcuchy znaków i określa, czy jeden jest permutacją drugiego.
 *
 * Wielkosc znakow i spacje maja znaczenie.
 */
public class FindPermutation {

    public static boolean isPermutation(String first, String second) {
        if (first == null || second == null) return false;
        if (first.length() != second.length()) return false;

        int[] occurance = new int[256];
        for (int i = 0; i < first.length(); i++) {
            occurance[first.charAt(i)]++;
        }

        for (int i = 0; i < second.length(); i++) {
            occurance[second.charAt(i)]--;
        }

        if (Arrays.stream(occurance)
                .filter(val -> val != 0)
                .findAny()
                .isPresent()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String first = "kkkat";
        String second = "tkkak";

        boolean isPerm = FindPermutation.isPermutation(first, second);

        System.out.println(isPerm);
    }
}
