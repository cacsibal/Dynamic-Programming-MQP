package org.dp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//https://www.geeksforgeeks.org/dsa/minimum-cost-to-reach-the-top-of-the-floor-by-climbing-stairs/
class MinCostClimbingStairTest {
    @Test
    void minCostClimbingStairs() {
        int[] cost = {10,15,20};
        MinCostClimbingStair testcase = new MinCostClimbingStair(cost);
        assertEquals(15, testcase.solution());
    }
    @Test
    void minCostClimbingStairs2() {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        MinCostClimbingStair testcase = new MinCostClimbingStair(cost);
        assertEquals(6, testcase.solution());
    }

}