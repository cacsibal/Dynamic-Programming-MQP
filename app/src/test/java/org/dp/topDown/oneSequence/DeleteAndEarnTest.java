package org.dp.topDown.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//https://leetcode.com/problems/delete-and-earn/description/
class DeleteAndEarnTest {

    @Test
    void deleteAndEarn() {
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        int[] input = {3,4,2};
        assertEquals(6, deleteAndEarn.solution(input));
    }
    @Test
    void deleteAndEarn1() {
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        int[] input = {2,2,3,3,3,4};
        assertEquals(9, deleteAndEarn.solution(input));
    }
}