package org.dp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerfectSquaresTest {

    @Test
    void test12() {
        PerfectSquares testSquares = new PerfectSquares();

        assertEquals(3, testSquares.solution(12));
    }

    /** https://leetcode.com/problems/perfect-squares/description/ */
    @Test
    void test13() {
        PerfectSquares testSquares = new PerfectSquares();

        assertEquals(2, testSquares.solution(13));
    }
}