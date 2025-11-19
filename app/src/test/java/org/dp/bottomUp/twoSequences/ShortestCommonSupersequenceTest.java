package org.dp.bottomUp.twoSequences;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShortestCommonSupersequenceTest {
    /**
     * https://leetcode.com/problems/shortest-common-supersequence/
     */
    @Test void test1() {
        ShortestCommonSupersequence testSCS = new ShortestCommonSupersequence();

        assertEquals("cabac", testSCS.solution("abac", "cab"));
    }

    /**
     * https://leetcode.com/problems/shortest-common-supersequence/
     */
    @Test void test2() {
        ShortestCommonSupersequence testSCS = new ShortestCommonSupersequence();

        assertEquals("aaaaaaaa", testSCS.solution("aaaaaaaa", "aaaaaaaa"));
    }
}
