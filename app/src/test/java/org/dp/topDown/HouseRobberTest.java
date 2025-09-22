package org.dp.topDown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {

    @Test
    public void test() {
        HouseRobber hr = new HouseRobber();
        int[] input = {2,7,9,3,1};
        assertEquals(12, hr.rob(input));
    }
}