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
        String formatMsg = String.format("Checking total: %d, power: %d, " +
                "number to check: %d", total, power, num);
        System.out.println(formatMsg);

        int value = total - ((int) Math.pow(num, power));

        if (value < 0) {
            System.out.println("not a solution");
            return 0;
        }
        if (value == 0) {
            System.out.println("solution: num: "+ num + "p" + power);
            return 1;
        }

        return recursiveSolution(value, power, num + 1)
                + recursiveSolution(total, power, num + 1);
    }


}
