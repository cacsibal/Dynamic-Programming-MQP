package org.dp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {

    @Test
    public void test() {

        int[] input = {2,7,9,3,1};
        HouseRobber hr = new HouseRobber(input);
        assertEquals(12, hr.solution());
    }
}