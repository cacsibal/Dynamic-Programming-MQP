package org.dp.topDown;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//https://www.geeksforgeeks.org/dsa/dice-throw-dp-30/
class DiceThrowTest {

    @Test
    void testDice(){
        DiceThrow testDiceThrow = new DiceThrow();
        assertEquals(25, testDiceThrow.solution(6,3,12));
    }
}