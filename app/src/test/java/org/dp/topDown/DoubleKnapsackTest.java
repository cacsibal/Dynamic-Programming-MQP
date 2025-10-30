package org.dp.topDown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoubleKnapsackTest {

    /** https://www.geeksforgeeks.org/dsa/double-knapsack-dynamic-programming//*/
    @Test
    void test_1() {
        DoubleKnapsack testDKP = new DoubleKnapsack();

        int[] weights = new int[]{8,3,2};
        int[] values = new int[]{8,3,2};
        assertEquals(13,testDKP.solution(10,3,weights,values ));
    }



}