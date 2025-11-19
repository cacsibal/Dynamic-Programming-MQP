package org.dp.topDown.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//https://www.geeksforgeeks.org/dsa/minimum-number-of-jumps-to-reach-end-of-a-given-array/
class JumpToTest {
    @Test
    void jumpTo() {
        JumpTo jumpTo = new JumpTo();
        int[] arr = {1,3,5,8,9,2,6,7,6,8, 9};
        assertEquals(3, jumpTo.minJumps(arr));
    }

    @Test
    void jumpTo2() {
        JumpTo jumpTo = new JumpTo();
        int[] arr = {0,10,20};
        assertEquals(-1, jumpTo.minJumps(arr));
    }

}