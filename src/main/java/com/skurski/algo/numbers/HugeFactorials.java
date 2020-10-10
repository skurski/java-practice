package com.skurski.algo.numbers;

import java.math.BigInteger;

public class HugeFactorials {

    public static void print(int n) {
        if (n < 0) throw new IllegalArgumentException("Should be positive number: " + n);
        if (n == 0) {
            System.out.println(1);
        }

        BigInteger result = BigInteger.valueOf(n);
        for (int i = n-1; i > 0; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        HugeFactorials.print(31);
    }
}
