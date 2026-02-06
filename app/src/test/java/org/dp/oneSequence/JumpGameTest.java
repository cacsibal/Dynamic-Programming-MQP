package org.dp.oneSequence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JumpGameTest {
    @Test
    void TrivialTest(){
        int[] vals = new int[]{1, 1, 1, 1};
        JumpGame testJumpGame = new JumpGame(vals);

        assertEquals(3, testJumpGame.solution_topdown());
    }

    /** https://leetcode.com/problems/jump-game-ii/ */
    @Test
    void AdvancedTest(){
        int[] vals = new int[]{2, 3, 0, 1, 4};
        JumpGame testJumpGame = new JumpGame(vals);

        assertEquals(2, testJumpGame.solution_topdown());
    }

    /** https://www.geeksforgeeks.org/dsa/minimum-number-of-jumps-to-reach-end-of-a-given-array/ */
    @Test
    void AdvancedTest2(){
        int[] vals = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        JumpGame testJumpGame = new JumpGame(vals);

        assertEquals(3, testJumpGame.solution_bottomup());
    }

    @Test
    void AdvancedTest3(){
        int[] vals = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        JumpGame testJumpGame = new JumpGame(vals);

        assertEquals(9, testJumpGame.solution_bottomup());
    }

    @Test
    void AdvancedTest4(){
        int[] vals = new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        JumpGame testJumpGame = new JumpGame(vals);

        assertEquals(-1, testJumpGame.solution_bottomup());
    }
}
