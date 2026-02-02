package org.dp.bottomUp.oneSequence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class MaxSubarrayTest {
    @Test
    void trivialTest() {
        int[] vals = new int[] {1,1,1,1,1};
        MaxSubarray testSubarray = new MaxSubarray(vals);

        assertEquals(5, testSubarray.solution());
    }

    /** https://leetcode.com/problems/maximum-subarray/description/ */
    @Test
    void advancedTest() {
        int[] vals = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubarray testSubarray = new MaxSubarray(vals);

        assertEquals(6, testSubarray.solution());
        System.out.println(testSubarray.retrieve());
    }
}