package org.dp.topDown.knapsack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {

    /** https://www.geeksforgeeks.org/dsa/double-knapsack-dynamic-programming/*/
    @Test
    void test_1() {
        Knapsack testKP = new Knapsack();

        int[] weights = new int[]{4,5,1};
        int[] values = new int[]{1,2,3};
        assertEquals(3,testKP.solution(4,weights,values ));
    }

    /** https://en.wikipedia.org/wiki/Knapsack_problem*/
    @Test
    void test_2() {
        Knapsack testKP = new Knapsack();

        int[] weights = new int[]{12,2,1,4,1};
        int[] values = new int[]{4,2,2,10,1};
        assertEquals(15,testKP.solution(15,weights,values ));
    }

}