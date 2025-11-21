package org.dp.bottomUp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {
    @Test
    void test1() {
        long[] coins = new long[]{1,5,10};
        CoinChange coinChange = new CoinChange();
        assertEquals(2, coinChange.solution(8, coins));
    }

    @Test
    void getWays() {
        long[] coins = new long[]{1,5,10};
        CoinChange coinChange = new CoinChange();
        assertEquals(4, coinChange.solution(10, coins));
    }
}