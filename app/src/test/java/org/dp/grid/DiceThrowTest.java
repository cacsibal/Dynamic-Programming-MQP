package org.dp.grid;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//https://www.geeksforgeeks.org/dsa/dice-throw-dp-30/
class DiceThrowTest {

    @Test
    void testDice(){
        DiceThrow testDiceThrow = new DiceThrow(6,3,12);
        assertEquals(25, testDiceThrow.solution());
    }
}