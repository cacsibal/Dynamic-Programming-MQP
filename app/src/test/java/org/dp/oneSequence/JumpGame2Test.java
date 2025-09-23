package org.dp.oneSequence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class JumpGame2Test {
    @Test
    void TrivialTest(){
        JumpGame2 testJumpGame = new JumpGame2();
        int[] vals = new int[]{1, 1, 1, 1};

        assertEquals(3, testJumpGame.jump(vals));
    }

    @Test
    void AdvancedTest(){
        JumpGame2 testJumpGame = new JumpGame2();
        int[] vals = new int[]{2, 3, 0, 1, 4};

        assertEquals(2, testJumpGame.jump(vals));
    }
}