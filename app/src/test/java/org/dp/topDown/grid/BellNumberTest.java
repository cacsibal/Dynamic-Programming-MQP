package org.dp.topDown.grid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//https://www.geeksforgeeks.org/dsa/bell-numbers-number-of-ways-to-partition-a-set/
class BellNumberTest {
    @Test
    void testSolution() {
        BellNumber testcase = new BellNumber();
        assertEquals(5, testcase.solution(3));
    }

    @Test
    void testSolution2() {
        BellNumber testcase = new BellNumber();
        assertEquals(2, testcase.solution(2));
    }
}