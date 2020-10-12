package com.skurski.algo.strings;

public class Palindrome {

    /**
     * Check if string is a palindrome
     */
    public boolean check(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Should contains at least one char");
        }

        int low = 0;
        int high = word.length() - 1;
        String lowerCase = word.toLowerCase();

        while (low < high) {
            if (lowerCase.charAt(low++) != lowerCase.charAt(high--)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Find out how many swaps are needed to make the given string palindrome
     * If not possible return -1
     */
    public int checkHowManySwaps(String word) {
        if (null == word || word.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int counter = 0;
        char[] lowerWord = word.toLowerCase().toCharArray();
        for (int low = 0, high = word.length() -1; low < high; low++, high--) {
            if (lowerWord[low] != lowerWord[high]) {
                // not a palindrome at this moment

                // finding char that is equal to lowerWord[low]
                int tempHigh = high;
                while (low < tempHigh) {
                    if (lowerWord[low] != lowerWord[tempHigh]) {
                        tempHigh--;
                    } else {
                        break;
                    }
                }

                // low index can be equal to tempHigh if no char was found
                // it is impossible to make the string palindrome so we are returning -1
                if (low == tempHigh) {
                    return -1;
                }

                // indexes are not equal so it means that low < tempHigh
                // char was found so we can make a swap
                // swapping char that we just founded with the char at high index
                char temp = lowerWord[high];
                lowerWord[high] = lowerWord[tempHigh];
                lowerWord[tempHigh] = temp;
                counter++;
            }
        }

        return counter;
    }


}
