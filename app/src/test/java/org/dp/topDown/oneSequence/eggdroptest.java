package org.dp.topDown.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//https://www.geeksforgeeks.org/dsa/egg-dropping-puzzle-dp-11/
class EggDropTest {

    @Test
    void solution() {
        EggDrop testegg = new EggDrop();
        assertEquals(8, testegg.solution(2,36));
    }
    @Test
    void solution2() {
        EggDrop testegg = new EggDrop();
        assertEquals(4, testegg.solution(2,10));
    }
}