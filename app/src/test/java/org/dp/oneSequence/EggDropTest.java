package org.dp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//https://www.geeksforgeeks.org/dsa/egg-dropping-puzzle-dp-11/
class EggDropTest {
    @Test
    void test1() {
        EggDrop eggDrop = new EggDrop(1,36);
        assertEquals(36, eggDrop.solution());
    }

    @Test
    void test2() {
        EggDrop eggDrop = new EggDrop(2,10);
        assertEquals(4, eggDrop.solution());
    }
}