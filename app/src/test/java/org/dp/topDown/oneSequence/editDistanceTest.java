package org.dp.topDown.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//https://www.geeksforgeeks.org/dsa/edit-distance-dp-5/
class editDistanceTest {
@Test
void test1() {
    String s1 = "abcd";
    String s2 = "bcfe";
    editDistance ed = new editDistance();
    assertEquals(3, ed.solution(s1, s2));
}

    @Test
    void test2() {
        String s1 = "gfg";
        String s2 = "gfg";
        editDistance ed = new editDistance();
        assertEquals(0, ed.solution(s1, s2));
    }
}