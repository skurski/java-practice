package com.skurski.algo.strings;

/**
 * Zaimplementuj algorytm określający, czy łańcuch zawiera tylko niepowtarzające się znaki.
 * Jak wykonasz to zadanie, jeśli nie można stosować dodatkowych struktur danych?
 */
public class DistinctCharacterString {

    private String text;

    public DistinctCharacterString(String text) {
        this.text = text;
    }

    public boolean check() {
        if (text == null || text.isEmpty()) {
            return false;
        }

        if (text.length() == 1) {
            return true;
        }

        if (text.length() > 256) {
            return false;
        }

        // The complexity is O(n2) and memory complexity is O(1)
        // We can use HashMap to make it O(n) but it is not allowed
//        if (nestedLoopSolution()) return false;

        // More advanced solution which is O(n) and memory O(1) uses table of integers
//        if (linearArrayOfIntSolution()) return false;

        // The complexity is also O(n) and memory is O(1) but the code is shorter
        if (linearArrayOfBoolSolution()) return false;

        return true;
    }

    private boolean nestedLoopSolution() {
        for (int i = 0; i < text.length(); i++) {
            char testChar = text.charAt(i);

            for (int j = i+1; j < text.length(); j++ ) {
                if (testChar == text.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean linearArrayOfIntSolution() {
        int[] charArr = new int[256];
        for (int i = 0; i < text.length(); i++) {
            int index = text.charAt(i);
            int value = charArr[index];
            value++;
            charArr[index] = value;
        }

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] > 1) {
                return true;
            }
        }
        return false;
    }

    private boolean linearArrayOfBoolSolution() {
        boolean[] charArr = new boolean[256];

        for  (int i = 0; i < text.length(); i++) {
            int index = text.charAt(i);
            if (charArr[index]) {
                return true;
            }

            charArr[index] = true;
        }

        return false;
    }

    public static void main(String[] args) {
        String test = "qwertyiuo";
        DistinctCharacterString distinctCharacterString = new DistinctCharacterString(test);
        boolean duplicateCharacters = distinctCharacterString.check();

        System.out.printf("String: %s contains distinct characters: %b", test, duplicateCharacters);
    }
}
