package com.skurski.algo.numbers;

/**
 * https://www.hackerrank.com/challenges/the-power-sum/problem
 */
public class PowerSum {

    public int powerSum(int total, int power) {
        int candidate = 1;
        return recursiveSolution(total, power, candidate);
    }

    private int recursiveSolution(int total, int power, int num) {
        int value = total - ((int) Math.pow(num, power));

        if (value < 0) return 0;
        if (value == 0) return 1;

        return recursiveSolution(value, power, num + 1) + recursiveSolution(total, power, num + 1);
    }

}
