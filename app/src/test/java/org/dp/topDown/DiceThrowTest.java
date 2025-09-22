package org.dp.topDown;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceThrowTest {

    @Test
    void testDice(){
        DiceThrow testDiceThrow = new DiceThrow();
        assertEquals(25, testDiceThrow.noOfWays(6,3,12));
    }
}