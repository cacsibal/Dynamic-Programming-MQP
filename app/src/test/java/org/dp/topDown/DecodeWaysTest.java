package org.dp.topDown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//https://www.geeksforgeeks.org/dsa/count-possible-decodings-given-digit-sequence/
class DecodeWaysTest {

    @Test
    public void test() {
        DecodeWays dw = new DecodeWays();
        assertEquals(1, dw.solution("10"));
        assertEquals(2, dw.solution("11"));
    }
}