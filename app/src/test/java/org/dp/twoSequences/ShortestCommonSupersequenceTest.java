package org.dp.twoSequences;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShortestCommonSupersequenceTest {
    /**
     * https://leetcode.com/problems/shortest-common-supersequence/
     */
    @Test void test1() {
        ShortestCommonSupersequence testSCS = new ShortestCommonSupersequence("abac", "cab");

        assertEquals("cabac", testSCS.retrieve());
    }

    /**
     * https://leetcode.com/problems/shortest-common-supersequence/
     */
    @Test void test2() {
        ShortestCommonSupersequence testSCS = new ShortestCommonSupersequence("aaaaaaaa", "aaaaaaaa");

        assertEquals("aaaaaaaa", testSCS.retrieve());
    }

    /**
     * https://www.geeksforgeeks.org/dsa/shortest-common-supersequence/
     */
    @Test void test3() {
        ShortestCommonSupersequence testSCS = new ShortestCommonSupersequence("geek", "eke");
        assertEquals(5, testSCS.solution());
    }

    /**
     * https://www.geeksforgeeks.org/dsa/shortest-common-supersequence/
     */
    @Test void test4() {
        ShortestCommonSupersequence testSCS = new ShortestCommonSupersequence("AGGTAB", "GXTXAYB");
        assertEquals(9, testSCS.solution());
    }
}
