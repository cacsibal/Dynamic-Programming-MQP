package org.dp.topDown.twoSequences;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceTest {
    /**
     * https://www.geeksforgeeks.org/dsa/longest-common-subsequence-dp-4/#
     */
    @Test void test1() {
        LongestCommonSubsequence testLCS = new LongestCommonSubsequence("abc", "ace");
        assertEquals(2, testLCS.solution());
    }

    /**
     * https://www.geeksforgeeks.org/dsa/longest-common-subsequence-dp-4/#
     */
    @Test void test2() {
        LongestCommonSubsequence testLCS = new LongestCommonSubsequence("aggtab", "gxtxayb");
        assertEquals(4, testLCS.solution());
    }

    /**
     * https://www.geeksforgeeks.org/dsa/longest-common-subsequence-dp-4/#
     */
    @Test void test3() {
        LongestCommonSubsequence testLCS = new LongestCommonSubsequence("abc", "cba");
        assertEquals(1, testLCS.solution());
    }
}