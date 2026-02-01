package org.dp.bottomUp.twoSequences;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceTest {
    /**
     * https://www.geeksforgeeks.org/dsa/longest-common-subsequence-dp-4/#
     */
    @Test void test1() {
        LongestCommonSubsequence testLCS = new LongestCommonSubsequence();
        int length = testLCS.solution("abc", "ace");
        String result = testLCS.retrieve();

        assertAll(
                () -> assertEquals(2, length, "LCS length"),
                () -> assertEquals("ac", result, "LCS string")
        );
    }

    /**
     * https://www.geeksforgeeks.org/dsa/longest-common-subsequence-dp-4/#
     */
    @Test void test2() {
        LongestCommonSubsequence testLCS = new LongestCommonSubsequence();
        int length = testLCS.solution("aggtab", "gxtxayb");
        String result = testLCS.retrieve();

        assertAll(
                () -> assertEquals(4, length, "LCS length"),
                () -> assertEquals("gtab", result, "LCS string")
        );
    }

    /**
     * https://www.geeksforgeeks.org/dsa/longest-common-subsequence-dp-4/#
     */
    @Test void test3() {
        LongestCommonSubsequence testLCS = new LongestCommonSubsequence();
        int length = testLCS.solution("abc", "cba");
        String result = testLCS.retrieve();

        assertAll(
                () -> assertEquals(1, length, "LCS length"),
                () -> assertEquals("c", result, "LCS string")
        );
    }
}