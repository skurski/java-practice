package com.skurski.algo.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinMaxSumTest {

    private MinMaxSum minMaxSum = new MinMaxSum();

    @Test
    public void shouldSuccessWithSortedArray() {
        int[] sortedArray = {1, 2, 3, 4, 5};

        long[] result = minMaxSum.miniMaxSum(sortedArray);

        Assertions.assertEquals(10, result[0]);
        Assertions.assertEquals(14, result[1]);
    }
}