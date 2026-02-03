package org.dp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//https://www.geeksforgeeks.org/dsa/count-possible-decodings-given-digit-sequence/
class DecodeWaysTest {

    @Test
    public void test() {
        DecodeWays dw = new DecodeWays("10");
        assertEquals(1, dw.solution());
    }
    @Test
    public void test2() {
        DecodeWays dw = new DecodeWays("11");
        assertEquals(2, dw.solution());
    }
    @Test
    public void test3() {
        DecodeWays dw = new DecodeWays("123");
        String[] result = {"ABC", "AW", "LC"};
        assertArrayEquals(new String[]{"ABC", "AW", "LC"}, dw.retrieve());
    }
}