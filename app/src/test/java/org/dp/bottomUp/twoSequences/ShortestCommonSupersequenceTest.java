package org.dp.bottomUp.twoSequences;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShortestCommonSupersequenceTest {
    /**
     * https://leetcode.com/problems/shortest-common-supersequence/
     */
    @Test void test1() {
        ShortestCommonSupersequence testSCS = new ShortestCommonSupersequence("abac", "cab");

        assertEquals("cabac", testSCS.solution());
    }

    /**
     * https://leetcode.com/problems/shortest-common-supersequence/
     */
    @Test void test2() {
        ShortestCommonSupersequence testSCS = new ShortestCommonSupersequence("aaaaaaaa", "aaaaaaaa");

        assertEquals("aaaaaaaa", testSCS.solution());
    }
}
