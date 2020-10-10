package com.skurski.algo.numbers;

public class MinMaxSum {

    public long[] miniMaxSum(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        long minSum = 0;
        long maxSum = 0;

        // first iteration to find the min and max
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        boolean omitElement = true;
        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i] && omitElement) {
                omitElement = false;
                continue;
            }
            minSum += arr[i];
        }

        omitElement = true;
        for (int i = 0; i < arr.length; i++) {
            if (min == arr[i] && omitElement) {
                omitElement = false;
                continue;
            }
            maxSum += arr[i];
        }

        System.out.println(minSum + " " + maxSum);

        long[] result = {minSum, maxSum};
        return result;
    }
}
