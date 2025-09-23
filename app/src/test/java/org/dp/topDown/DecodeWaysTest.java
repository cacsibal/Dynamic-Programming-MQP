package org.dp.topDown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeWaysTest {

    @Test
    public void test() {
        DecodeWays dw = new DecodeWays();
        assertEquals(1, dw.numDecodings("10"));
        assertEquals(2, dw.numDecodings("11"));
    }
}