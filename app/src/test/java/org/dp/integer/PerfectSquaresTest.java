package org.dp.integer;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PerfectSquaresTest {

    /** https://leetcode.com/problems/perfect-squares/description/ */
    @Test
    void test12() {
        PerfectSquares testSquares = new PerfectSquares(12);

        assertEquals(3, testSquares.solution());
        assertArrayEquals(new Integer[]{1,1,1,9}, testSquares.retrieve());
    }

    /** https://leetcode.com/problems/perfect-squares/description/ */
    @Test
    void test13() {
        PerfectSquares testSquares = new PerfectSquares(13);

        assertEquals(2, testSquares.solution());
        assertArrayEquals(new Integer[]{4,9}, testSquares.retrieve());
    }
}
