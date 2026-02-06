package org.dp.bottomUp.oneSequence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class JumpGame2Test {
    @Test
    void TrivialTest(){
        int[] vals = new int[]{1, 1, 1, 1};
        JumpGame2 testJumpGame = new JumpGame2(vals);

        assertEquals(3, testJumpGame.solution());
    }

    /** https://leetcode.com/problems/jump-game-ii/ */
    @Test
    void AdvancedTest(){
        int[] vals = new int[]{2, 3, 0, 1, 4};
        JumpGame2 testJumpGame = new JumpGame2(vals);

        assertEquals(2, testJumpGame.solution());
    }
}