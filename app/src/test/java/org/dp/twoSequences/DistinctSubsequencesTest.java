package org.dp.twoSequences;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DistinctSubsequencesTest {
    /**
     * https://leetcode.com/problems/distinct-subsequences/description/
     */
    @Test void test1() {
        DistinctSubsequences testDistinctSubsequences = new DistinctSubsequences("rabbbit", "rabbit");
        int solution = testDistinctSubsequences.solution();
        String retrieve = testDistinctSubsequences.retrieve();

        assertAll(
                () -> assertEquals(3, solution),
                () -> assertEquals("rabbit", retrieve)
        );
    }

    /**
     * https://leetcode.com/problems/distinct-subsequences/description/
     */
    @Test void test2() {
        DistinctSubsequences testDistinctSubsequences = new DistinctSubsequences("babgbag", "bag");
        int solution = testDistinctSubsequences.solution();
        String retrieve = testDistinctSubsequences.retrieve();

        assertAll(
                () -> assertEquals(5, solution),
                () -> assertEquals("bag", retrieve)
        );
    }
}
