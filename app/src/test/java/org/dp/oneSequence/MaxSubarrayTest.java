package org.dp.oneSequence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class MaxSubarrayTest {
    @Test
    void trivialTest() {
        MaxSubarray testSubarray = new MaxSubarray();
        int[] vals = new int[] {1,1,1,1,1};

        assertEquals(5, testSubarray.maxSubArray(vals));
    }

    @Test
    void advancedTest() {
        MaxSubarray testSubarray = new MaxSubarray();
        int[] vals = new int[] {-2,1,-3,4,-1,2,1,-5,4};

        assertEquals(6, testSubarray.maxSubArray(vals));
    }
}