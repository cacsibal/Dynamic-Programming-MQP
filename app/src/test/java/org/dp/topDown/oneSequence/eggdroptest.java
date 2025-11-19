package org.dp.topDown.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class eggDropTest {
    @Test
    void eggDrop() {
        eggDrop testeggDrop = new eggDrop();
        assertEquals(8, testeggDrop.solution(2,36));
    }
}