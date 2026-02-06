package org.dp.topDown.twoSequences;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MinimumDeleteSumTest {
    /**
     * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
     */
    @Test void test1() {
        MinimumDeleteSum testDeleteSum = new MinimumDeleteSum("sea", "eat");
        assertEquals(231, testDeleteSum.solution());
    }

    /**
     * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
     */
    @Test void test2() {
        MinimumDeleteSum testDeleteSum = new MinimumDeleteSum("delete", "leet");
        assertEquals(403, testDeleteSum.solution());
    }
}
