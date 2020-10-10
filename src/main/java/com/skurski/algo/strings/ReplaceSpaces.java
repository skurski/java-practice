package com.skurski.algo.strings;

import java.util.Arrays;

/**
 * Napisz metodę, która zastępuje wszystkie spacje w łańcuchu znaków sekwencją %20.
 * Przyjmij, że na końcu łańcucha dostępne jest miejsce na dodatkowe znaki, a także że
 * znasz prawdziwą długość łańcucha. Jeśli implementujesz rozwiązanie w Javie, zastosuj
 * tablicę znaków, aby móc wykonać operację w miejscu (bez kopiowania łańcuchów).
 * PRZYKŁAD:
 * Dane wejściowe: "Pan Jan Nowak ", 13
 * Dane wyjściowe: "Pan%20Jan%20Nowak"
 */
public class ReplaceSpaces {

    public static String replace(char[] text, int length) {
        int spaces = 0;
        for (int i = 0; i < length; i++) {
            if (text[i] == ' ') {
                spaces++;
            }
        }

        int newLength = length + 2 * spaces; // 17

        for (int i = length - 1; i >= 0; i--) {
            if (text[i] == ' ') {
                text[newLength-1] = '0';
                text[newLength-2] = '2';
                text[newLength-3] = '%';
                newLength = newLength - 3;
            } else {
                text[newLength-1] = text[i];
                newLength = newLength - 1;
            }
            System.out.println(Arrays.toString(text));
        }

        return new String(text);
    }

    public static void main(String[] args) {

        char[] text = "Pan Jan Nowak    ".toCharArray();

        String first = ReplaceSpaces.replace(text, 13);

        System.out.println(first);

    }
}
