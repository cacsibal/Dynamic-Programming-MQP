package org.dp.topDown.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EggDropTest {

    @Test
    void solution() {
        eggDrop testegg = new eggDrop();
        assertEquals(8, testegg.solution(2,36));
    }
}