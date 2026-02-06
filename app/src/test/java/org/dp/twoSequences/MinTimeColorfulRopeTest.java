package org.dp.twoSequences;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/
class MinTimeColorfulRopeTest {
    @Test
    public void Solution() {

        String color = "abaac";
        int[] neededTime = new int[] {1,2,3,4,5};
        MinTimeColorfulRope testcase = new MinTimeColorfulRope(color, neededTime);
        assertEquals(3, testcase.solution());
    }

    @Test
    public void Solution2() {

        String color = "abc";
        int[] neededTime = new int[] {1,2,3};
        MinTimeColorfulRope testcase = new MinTimeColorfulRope(color, neededTime);
        assertEquals(0, testcase.solution());
    }

}