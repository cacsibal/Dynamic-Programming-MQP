package org.dp.twoSequences;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceTest {
    /**
     * https://www.geeksforgeeks.org/dsa/longest-common-subsequence-dp-4/#
     */
    @Test void test1() {
        LongestCommonSubsequence testLCS = new LongestCommonSubsequence("abc", "ace");
        int length = testLCS.solution_bottomup();
        String result = testLCS.retrieve();

        assertEquals(2, length, "LCS length");
        assertEquals("ac", result, "LCS string");
    }

    /**
     * https://www.geeksforgeeks.org/dsa/longest-common-subsequence-dp-4/#
     */
    @Test void test2_bu() {
        LongestCommonSubsequence testLCS = new LongestCommonSubsequence("aggtab", "gxtxayb");
        int length = testLCS.solution_bottomup();
        String result = testLCS.retrieve();

        assertEquals(4, length, "LCS length");
        assertEquals("gtab", result, "LCS string");
    }

    /**
     * https://www.geeksforgeeks.org/dsa/longest-common-subsequence-dp-4/#
     */
    @Test void test2_td() {
        LongestCommonSubsequence testLCS = new LongestCommonSubsequence("aggtab", "gxtxayb");
        int length = testLCS.solution_topdown();
        String result = testLCS.retrieve();

        assertEquals(4, length, "LCS length");
        assertEquals("gtab", result, "LCS string");
    }

    /**
     * https://www.geeksforgeeks.org/dsa/longest-common-subsequence-dp-4/#
     */
    @Test void test3() {
        LongestCommonSubsequence testLCS = new LongestCommonSubsequence("abc", "cba");
        int length = testLCS.solution_bottomup();
        String result = testLCS.retrieve();

        assertEquals(1, length, "LCS length");
        assertEquals("c", result, "LCS string");
    }
}