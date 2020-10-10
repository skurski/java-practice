package com.skurski.algo.strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Encryption {

    public String encryption(String text) {
        String trimed = Arrays
                .stream(text.split(" "))
                .map(word -> word.trim())
                .collect(Collectors.joining());

        double sqrt = Math.sqrt(trimed.length());
        int rows = (int) Math.round(sqrt);
        int cols = (int) Math.ceil(sqrt);

        char result[][] = new char[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (index < trimed.length()) {
                    result[i][j] = trimed.charAt(index++);
                }
            }
        }

        StringBuilder encoded = new StringBuilder();

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (result[j][i] != '\u0000') {
                    encoded.append(result[j][i]);
                }
            }
            encoded.append(" ");
        }

        System.out.println(encoded.toString().trim());
        return encoded.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new Encryption().encryption("feedthedog"));
    }
}
