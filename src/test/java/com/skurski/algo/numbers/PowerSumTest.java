package com.skurski.algo.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PowerSumTest {

    private PowerSum powerSum = new PowerSum();

    @Test
    void shouldSuccessWithBaseCaseOnly() {
        int result = powerSum.powerSum(1, 2);

        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldSuccessWithEasyExample() {
        int result = powerSum.powerSum(10, 2);

        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldSuccessWithEasyExample2() {
        int result = powerSum.powerSum(100, 2);

        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldSuccessWithEasyExample3() {
        int result = powerSum.powerSum(100, 3);

        Assertions.assertEquals(1, result);
    }
}