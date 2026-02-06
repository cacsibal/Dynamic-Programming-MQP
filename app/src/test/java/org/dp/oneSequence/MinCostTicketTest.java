package org.dp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinCostTicketTest {
    @Test
    void solution() {

        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        MinCostTicket testcase = new MinCostTicket(days,costs);
        assertEquals(11,testcase.solution());
    }

    @Test
    void solution2() {
        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2,7,15};
        MinCostTicket testcase = new MinCostTicket(days,costs);
        assertEquals(17,testcase.solution());
    }
}