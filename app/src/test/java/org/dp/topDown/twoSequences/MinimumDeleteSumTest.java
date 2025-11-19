package org.dp.topDown.twoSequences;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MinimumDeleteSumTest {
    /**
     * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
     */
    @Test void test1() {
        MinimumDeleteSum testDeleteSum = new MinimumDeleteSum();
        assertEquals(231, testDeleteSum.solution("sea", "eat"));
    }

    /**
     * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
     */
    @Test void test2() {
        MinimumDeleteSum testDeleteSum = new MinimumDeleteSum();
        assertEquals(403, testDeleteSum.solution("delete", "leet"));
    }
}
