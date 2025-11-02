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

    @Test
    void test_2() {
        DoubleKnapsack testDKP = new DoubleKnapsack();

        int[] weights = new int[]{2,3,4,5,6};
        int[] values = new int[]{3,4,5,8,10};
        assertEquals(22,testDKP.solution(8,7,weights,values ));
    }



}