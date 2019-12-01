package com.skurski.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Tasks {

    // 0 bit first, 1 after
    // [1,1,0,0,1,0,1]
    public static void sortBits(int[] bits) {
        int low = 0;
        int high = bits.length - 1;
        while (low < high) {
            while (bits[low] == 0) low++;
            while (bits[high] == 1) high--;

            if (low < high) {
                int temp = bits[low];
                bits[low] = bits[high];
                bits[high] = temp;
            }
        }

        System.out.println(Arrays.toString(bits));
    }

    // count all letters except white spaces
    public static Map<Character, Integer> countLetters(String text) {
        if (text == null || text.isEmpty()) return new HashMap<>();

        String trimmed = text.replaceAll("[,;:' !?()]", "").trim().toLowerCase();
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < trimmed.length(); i++) {
            Integer value = counter.get(trimmed.charAt(i));
            if (value == null) {
                value = 1;
            } else {
                value++;
            }
            counter.put(trimmed.charAt(i), value);
        }

        return counter;
    }

    public static void main(String[] args) {

        sortBits(new int[]{1, 1, 0, 0, 1, 0, 1});
        System.out.println(countLetters("This is my first algo, great job!"));
    }
}
