package org.dp.topDown.twoSequences;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceTest {
    /**
     * https://www.geeksforgeeks.org/dsa/longest-common-subsequence-dp-4/#
     */
    @Test void test1() {
        LongestCommonSubsequence testLCS = new LongestCommonSubsequence();
        assertEquals(2, testLCS.solution("abc", "ace"));
    }

    /**
     * https://www.geeksforgeeks.org/dsa/longest-common-subsequence-dp-4/#
     */
    @Test void test2() {
        LongestCommonSubsequence testLCS = new LongestCommonSubsequence();
        assertEquals(4, testLCS.solution("aggtab", "gxtxayb"));
    }

    /**
     * https://www.geeksforgeeks.org/dsa/longest-common-subsequence-dp-4/#
     */
    @Test void test3() {
        LongestCommonSubsequence testLCS = new LongestCommonSubsequence();
        assertEquals(1, testLCS.solution("abc", "cba"));
    }
}