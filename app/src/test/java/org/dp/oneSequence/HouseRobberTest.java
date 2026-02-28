package org.dp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//https://leetcode.com/problems/house-robber/description/
class HouseRobberTest {

    @Test
    public void test() {

        int[] input = {2,7,9,3,1};
        HouseRobber hr = new HouseRobber(input);
        assertEquals(12, hr.solution());
    }

    @Test
    public void test1() {
        int[] input = {1,2,3,1};
        HouseRobber testhr = new HouseRobber(input);
        assertEquals(4, testhr.solution());
    }
}