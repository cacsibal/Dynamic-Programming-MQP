package org.dp.knapsack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {

    /** https://www.geeksforgeeks.org/dsa/double-knapsack-dynamic-programming/*/
    @Test
    void test_1() {
        int[] weights = new int[]{4,5,1};
        int[] values = new int[]{1,2,3};
        Knapsack testKP = new Knapsack(4,weights,values);
        assertEquals(3,testKP.solution());
    }

    /** https://en.wikipedia.org/wiki/Knapsack_problem*/
    @Test
    void test_2() {

        int[] weights = new int[]{12,2,1,4,1};
        int[] values = new int[]{4,2,2,10,1};
        Knapsack testKP = new Knapsack(15,weights,values);
        assertEquals(15,testKP.solution());
    }

}