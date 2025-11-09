package org.dp.topDown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountNumbersWithUniqueDigitsTest {

    @Test
    void test1() {
        CountNumbersWithUniqueDigits testCNWUD = new CountNumbersWithUniqueDigits();

        assertEquals(91, testCNWUD.solution(2));
    }

    @Test
    void test2() {
        CountNumbersWithUniqueDigits testCNWUD = new CountNumbersWithUniqueDigits();

        assertEquals(5275, testCNWUD.solution(4));
    }
}