package org.dp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//https://leetcode.com/problems/count-numbers-with-unique-digits/description/
class CountNumbersWithUniqueDigitsTest {

    @Test
    void test1() {
        CountNumbersWithUniqueDigits testCNWUD = new CountNumbersWithUniqueDigits(2);

        assertEquals(91, testCNWUD.solution());
    }

    @Test
    void test2() {
        CountNumbersWithUniqueDigits testCNWUD = new CountNumbersWithUniqueDigits(4);

        assertEquals(5275, testCNWUD.solution());
    }
}