package org.dp.oneSequence;

import org.junit.jupiter.api.Test;
//https://www.geeksforgeeks.org/dsa/0-1-knapsack-problem-dp-10/
import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {
@Test
void testKnapsack() {
    int[] val = {1,2,3};
    int[] wt = {4,5,1};
    int w = 4;
    Knapsack knapsack = new Knapsack();
    assertEquals(3, knapsack.solution(w, val, wt));
}

    @Test
    void testKnapsack2() {
        int[] wt = {2,3,4};
        int[] val = {4,5,6};
        int w = 5;
        Knapsack knapsack = new Knapsack();
        assertEquals(9, knapsack.solution(w, val, wt));
    }
}