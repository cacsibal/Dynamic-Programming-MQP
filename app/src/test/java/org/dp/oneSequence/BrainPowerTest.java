package org.dp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//https://leetcode.com/problems/solving-questions-with-brainpower/description/
class BrainPowerTest {

    @Test
    public void solution() {
        int[][] question = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        BrainPower testcase = new BrainPower();
        assertEquals(7, testcase.solution(question));
    }

    @Test
    public void solution2() {
        int[][] question = {{3, 2}, {4, 3}, {4, 4}, {2, 5}};
        BrainPower testcase = new BrainPower();
        assertEquals(5, testcase.solution(question));
    }
}