package org.dp.topDown.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//https://www.geeksforgeeks.org/dsa/minimum-number-of-jumps-to-reach-end-of-a-given-array/
class JumpTwoTest {
    @Test
    void jumpTo() {
        JumpTwo jumpTwo = new JumpTwo();
        int[] arr = {1,3,5,8,9,2,6,7,6,8, 9};
        assertEquals(3, jumpTwo.solution(arr));
    }

    @Test
    void jumpTo2() {
        JumpTwo jumpTwo = new JumpTwo();
        int[] arr = {0,10,20};
        assertEquals(-1, jumpTwo.solution(arr));
    }
    @Test
    void jumpTo3() {
        JumpTwo jumpTwo = new JumpTwo();
        int[] arr = {0,10,20};
        assertEquals(-1, jumpTwo.solutiontwo(arr));
    }

    @Test
    void jumpTo4() {
        JumpTwo jumpTwo = new JumpTwo();
        int[] arr = {1,3,5,8,9,2,6,7,6,8, 9};
        assertEquals(3, jumpTwo.solutiontwo(arr));
    }

}