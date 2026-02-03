package org.dp.strings;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class InterleavingStringsTest {

    /** https://leetcode.com/problems/interleaving-string/*/
    @Test
    void test12() {
        InterleavingStrings testStrings = new InterleavingStrings("aabcc", "dbbca", "aadbbcbcac");

        assertTrue(testStrings.solution());
    }

    /** https://www.youtube.com/watch?v=ih2OZ9-M3OM */
    @Test
    void test13() {
        InterleavingStrings testStrings = new InterleavingStrings("aab", "axy", "aaxaby");

        assertTrue(testStrings.solution());

        InterleavingStrings testStrings2 = new InterleavingStrings("aab", "axy", "abaaxy");

        assertFalse(testStrings2.solution());
    }
}
