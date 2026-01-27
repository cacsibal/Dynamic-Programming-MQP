package org.dp.bottomUp.oneSequence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LongestIncreasingSubsequenceTest {
    /** https://en.wikipedia.org/wiki/Longest_increasing_subsequence */
    @Test
    void wikipediaSolution() {
        int[] vals = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        LongestIncreasingSubsequence testSubsequence = new LongestIncreasingSubsequence(vals);

        assertEquals(6, testSubsequence.solution());
    }

    /** https://www.geeksforgeeks.org/dsa/longest-increasing-subsequence-dp-3/ */
    @Test
    void geeksForGeeksSolution() {

        int[] vals = new int[] { 3, 10, 2, 1, 20};
        LongestIncreasingSubsequence testSubsequence = new LongestIncreasingSubsequence(vals);

        assertEquals(3, testSubsequence.solution());
    }
}