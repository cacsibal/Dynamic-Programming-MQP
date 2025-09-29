package org.dp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//https://www.geeksforgeeks.org/dsa/understanding-the-coin-change-problem-with-dynamic-programming/
class coinChangeTest {

    @Test
    void test1() {
        long[] coins = new long[]{1,5,10};
        coinChange coinChange = new coinChange();
        assertEquals(2, coinChange.solution(8, coins));
    }

    @Test
    void getWays() {
        long[] coins = new long[]{1,5,10};
        coinChange coinChange = new coinChange();
        assertEquals(4, coinChange.solution(10, coins));
    }
}