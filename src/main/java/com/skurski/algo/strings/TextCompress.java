package com.skurski.algo.strings;

import java.util.Arrays;

/**
 * Zaimplementuj metodę, która przeprowadza prostą kompresję łańcuchów znaków opartą
 * na zliczaniu powtarzających się liter. Na przykład metoda ma przekształcać łańcuch
 * aabcccccaaa na a2b1c5a3. Jeśli „skompresowany” łańcuch znaków nie jest mniejszy od
 * wyjściowego, metoda powinna zwracać pierwotny łańcuch.
 */
public class TextCompress {

    public String compress(String input) {
        int size = countCompressString(input);
        System.out.println("Compress string size: " + size);
        if (size >= input.length()) {
            return input;
        }

        char[] inputArray = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < inputArray.length) {
            char letter = inputArray[index];
            int counter = 1;

            while (index + 1 < inputArray.length && inputArray[index + 1] == letter) {
                index++;
                counter++;
            }

            sb.append(letter);
            sb.append(counter);

            index++;
        }

        return sb.toString();
    }

    private int countCompressString(String input) {
        int size = 0;

        char[] inputArray = input.toCharArray();
        int index = 0;
        while (index < inputArray.length) {
            char letter = inputArray[index];
            int counter = 1;

            while (index+1 < inputArray.length && inputArray[index+1] == letter)  {
                index++;
                counter++;
            }

            size += 1 + String.valueOf(counter).length();
            index++;
        }

        return size;
    }


    public static void main(String[] args) {
        String input = "aabcccccaaa";
//        String input = "abcde";
//        String input = "aaaaaaaabbcdefffffff";
        System.out.println("Compress text for input string: " + input + " is => "
                + new TextCompress().compress(input));
    }
}
