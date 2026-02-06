package org.dp.grid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//https://www.geeksforgeeks.org/dsa/bell-numbers-number-of-ways-to-partition-a-set/
class BellNumberTest {
    @Test
    void testSolution() {
        BellNumber testcase = new BellNumber(3);
        assertEquals(5, testcase.solution());
    }

    @Test
    void testSolution2() {
        BellNumber testcase = new BellNumber(2);
        assertEquals(2, testcase.solution());
    }
}