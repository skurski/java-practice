package com.skurski.algo.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    private Palindrome palindrome = new Palindrome();

    @Test
    void shouldSuccess() {
        boolean palindrom = this.palindrome.check("Madam");

        assertEquals(true, palindrom);
    }

    @Test
    void shouldFail() {
        boolean palindrom = this.palindrome.check("Rotamor");

        assertEquals(false, palindrom);
    }

    @Test
    void shouldCountNumberOfSwaps() {
        int swaps = this.palindrome.checkHowManySwaps("aabcb");

        assertEquals(2, swaps);
    }

    @Test
    void shouldFailBecauseSwapsNotPossible() {
        int swaps = this.palindrome.checkHowManySwaps("adbcdbad");

        assertEquals(-1, swaps);
    }
}