package org.dp.topDown.knapsack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoubleKnapsackTest {

    /** https://www.geeksforgeeks.org/dsa/double-knapsack-dynamic-programming//*/
    @Test
    void test_1() {
        int[] weights = new int[]{8,3,2};
        int[] values = new int[]{8,3,2};
        DoubleKnapsack testDKP = new DoubleKnapsack(10,3,weights,values );
        assertEquals(13,testDKP.solution());
    }

    @Test
    void test_2() {
        int[] weights = new int[]{2,3,4,5,6};
        int[] values = new int[]{3,4,5,8,10};
        DoubleKnapsack testDKP = new DoubleKnapsack(8,7,weights,values );
        assertEquals(22,testDKP.solution());
    }



}