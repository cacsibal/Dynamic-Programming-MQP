package org.dp.topDown.knapsack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OnesAndZeroesTest {

    /** https://leetcode.com/problems/ones-and-zeroes */
    @Test
    void test1() {
        OnesAndZeroes testOAZ = new OnesAndZeroes();

        String[] strs = new String[]{"10","0001","111001","1","0"};
        int m=5;
        int n=3;
        assertEquals(4,testOAZ.solution(strs,m,n));
    }

    /** https://leetcode.com/problems/ones-and-zeroes */
    @Test
    void test2() {
        OnesAndZeroes testOAZ = new OnesAndZeroes();

        String[] strs = new String[]{"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"};
        int m=90;
        int n=66;
        assertEquals(29,testOAZ.solution(strs,m,n));
    }
}