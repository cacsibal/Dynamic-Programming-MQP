package org.dp.bottomUp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinCostTicketTest {
    @Test
    void solution() {
        MinCostTicket testcase = new MinCostTicket();
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        assertEquals(11,testcase.solution(days, costs));
    }

    @Test
    void solution2() {
        MinCostTicket testcase = new MinCostTicket();
        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2,7,15};
        assertEquals(17,testcase.solution(days, costs));
    }
}