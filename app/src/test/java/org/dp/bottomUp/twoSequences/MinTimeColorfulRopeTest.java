package org.dp.bottomUp.twoSequences;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/
class MinTimeColorfulRopeTest {
    @Test
    public void Solution() {
        MinTimeColorfulRope testcase = new MinTimeColorfulRope();
        String color = "abaac";
        int[] neededTime = new int[] {1,2,3,4,5};
        assertEquals(3, testcase.solution(color, neededTime));
    }

    @Test
    public void Solution2() {
        MinTimeColorfulRope testcase = new MinTimeColorfulRope();
        String color = "abc";
        int[] neededTime = new int[] {1,2,3};
        assertEquals(0, testcase.solution(color, neededTime));
    }

}