package com.skurski.algo.numbers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindSumTest {

    private static final int SUM = 12;

    private FindSum findSum = new FindSum();

    @Test
    public void shouldReturnNullIfZeroElement() {
        // given
        Integer[] array = new Integer[]{};

        // when
        Integer[] tuples = findSum.ofDistinct(array, SUM);

        // then
        Assertions.assertEquals(null, tuples);
    }


    @Test
    public void shouldReturnNullIfOneElement() {
        // given
        Integer[] array = new Integer[]{1};

        // when
        Integer[] tuples = findSum.ofDistinct(array, SUM);

        // then
        Assertions.assertEquals(null, tuples);
    }


    @Test
    public void shouldReturnNullIfTwoElementsWithoutSum() {
        // given
        Integer[] array = new Integer[]{1, 2};

        // when
        Integer[] tuples = findSum.ofDistinct(array, SUM);

        // then
        Assertions.assertEquals(null, tuples);
    }

    @Test
    public void shouldSuccessWhenTwoElementsWithSum() {
        // given
        Integer[] array = new Integer[]{1, 11};

        // when
        Integer[] tuples = findSum.ofDistinct(array, SUM);

        // then
        Assertions.assertArrayEquals(new Integer[]{1, 11}, tuples);
    }

    @Test
    public void shouldSuccessWhenMultipleDistinctElements() {
        // given
        Integer[] array = new Integer[]{1, 3, 5, 8, -5, 11, 14};

        // when
        Integer[] tuples = findSum.ofDistinct(array, SUM);

        // then
        Assertions.assertArrayEquals(new Integer[]{1, 11}, tuples);
    }

    @Test
    public void shouldFailWhenMultipleElementsWithoutSum() {
        // given
        Integer[] array = new Integer[]{1, 3, 5, 8, -5, 10, 14};

        // when
        Integer[] tuples = findSum.ofDistinct(array, SUM);

        // then
        Assertions.assertArrayEquals(null, tuples);
    }
}