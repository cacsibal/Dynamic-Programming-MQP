package org.dp.knapsack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultipleKnapsackTest {
    @Test
    void test_1() {
        int[] weights = new int[]{2,3,4,5,6};
        int[] values = new int[]{3,4,5,8,10};

        MultipleKnapsack testMKP = new MultipleKnapsack(new int[]{8,7},weights,values );

        assertEquals(22,testMKP.solution());
    }
}