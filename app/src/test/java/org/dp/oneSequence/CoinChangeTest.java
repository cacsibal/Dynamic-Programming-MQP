package org.dp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {

    @Test
    void test_1() {


        int[] coins = new int[]{1,2,5};
        int amount = 11;
        CoinChange testCC = new CoinChange(coins,amount);
        assertEquals(3,testCC.solution());
    }

    @Test
    void test_2() {


        int[] coins = new int[]{411,412,413,414,415,416,417,418,419,420,421,422};
        int amount = 9864;
        CoinChange testCC = new CoinChange(coins,amount);
        assertEquals(24,testCC.solution());
    }
}