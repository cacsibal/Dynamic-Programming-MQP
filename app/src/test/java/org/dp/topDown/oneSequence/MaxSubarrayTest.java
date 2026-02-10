package org.dp.topDown.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MaxSubarrayTest {
    @Test
    void trivialTest() {
        System.out.println("can anyone hear me?");
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
    }
}