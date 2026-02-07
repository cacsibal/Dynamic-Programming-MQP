package org.dp.oneSequence;

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
        assertEquals(6, testSubarray.solution_bottomup());
    }

    /** https://leetcode.com/problems/maximum-subarray/description/ */
    @Test
    void advancedTest2() {
        int[] vals = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubarray testSubarray = new MaxSubarray(vals);
        assertEquals(6, testSubarray.solution_topdown());
        assertEquals("A[3..6]", testSubarray.retrieve());
    }

    /** https://leetcode.com/problems/maximum-subarray/description/ */
    @Test
    void advancedTest3() {
        int[] vals = new int[] {-2,1,-3,4,-1,2,1,-5,4,-9,-9,-9,-9,-9,-9,4,-1,2,2,-9,-9,-9,-9};
        MaxSubarray testSubarray = new MaxSubarray(vals);
        assertEquals(7, testSubarray.solution_topdown());
        assertEquals("A[15..18]", testSubarray.retrieve());
    }
}