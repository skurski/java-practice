package com.skurski.algo.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromTest {

    private Palindrom palindrom = new Palindrom();

    @Test
    void shouldSuccess() {
        boolean palindrom = this.palindrom.check("Madam");

        assertEquals(true, palindrom);
    }

    @Test
    void shouldFail() {
        boolean palindrom = this.palindrom.check("Rotamor");

        assertEquals(false, palindrom);
    }

    @Test
    void shouldCountNumberOfSwaps() {
        int swaps = this.palindrom.checkHowManySwaps("aabcb");

        assertEquals(2, swaps);
    }

    @Test
    void shouldFailBecauseSwapsNotPossible() {
        int swaps = this.palindrom.checkHowManySwaps("adbcdbad");

        assertEquals(-1, swaps);
    }
}