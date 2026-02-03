package org.dp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//https://leetcode.com/problems/delete-and-earn/description/
class DeleteAndEarnTest {

    @Test
    void deleteAndEarn() {
        int[] input = {3,4,2};
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn(input);
        assertEquals(6, deleteAndEarn.solution());
    }
    @Test
    void deleteAndEarn1() {
        int[] input = {2,2,3,3,3,4};
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn(input);
        assertEquals(9, deleteAndEarn.solution());
    }
}