package org.dp.topDown.twoSequences;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DistinctSubsequencesTest {
    /**
     * https://leetcode.com/problems/distinct-subsequences/description/
     */
    @Test void test1() {
        DistinctSubsequences testDistinctSubsequences = new DistinctSubsequences();
        assertEquals(3, testDistinctSubsequences.solution("rabbbit", "rabbit"));
    }

    /**
     * https://leetcode.com/problems/distinct-subsequences/description/
     */
    @Test void test2() {
        DistinctSubsequences testDistinctSubsequences = new DistinctSubsequences();
        assertEquals(5, testDistinctSubsequences.solution("babgbag", "bag"));
    }
}
