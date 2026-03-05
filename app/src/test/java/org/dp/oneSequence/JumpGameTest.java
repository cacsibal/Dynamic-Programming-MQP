package org.dp.oneSequence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/jump-game/description/
class JumpGameTest {
    @Test
    void test1(){
        JumpGame testcase = new JumpGame(new int[]{2,3,1,1,4});
        assertTrue(testcase.solution());
    }
    @Test
    void test2(){
        JumpGame testcase = new JumpGame(new int[]{3,2,1,0,4});
        assertFalse(testcase.solution());
    }
}
