package org.dp.topDown.twoSequences;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceTest {
    /**
     * https://www.geeksforgeeks.org/dsa/longest-common-subsequence-dp-4/#
     */
    @Test void test1() {
        LongestCommonSubsequence testLCS = new LongestCommonSubsequence("abc", "ace");
        int solution = testLCS.solution();
        String retrieve = testLCS.retrieve();

        assertAll(
                () -> assertEquals(2, solution, "LCS length"),
                () -> assertEquals("ac", retrieve, "LCS string")
        );
    }

    /**
     * https://www.geeksforgeeks.org/dsa/longest-common-subsequence-dp-4/#
     */
    @Test void test2() {
        LongestCommonSubsequence testLCS = new LongestCommonSubsequence("aggtab", "gxtxayb");
        int solution = testLCS.solution();
        String retrieve = testLCS.retrieve();

        assertAll(
                () -> assertEquals(4, solution, "LCS length"),
                () -> assertEquals("gtab", retrieve, "LCS string")
        );
    }

    /**
     * https://www.geeksforgeeks.org/dsa/longest-common-subsequence-dp-4/#
     */
    @Test void test3() {
        LongestCommonSubsequence testLCS = new LongestCommonSubsequence("abc", "cba");
        int solution = testLCS.solution();
        String retrieve = testLCS.retrieve();

        assertAll(
                () -> assertEquals(1, solution, "LCS length"),
                () -> assertEquals("c", retrieve, "LCS string")
        );
    }
}