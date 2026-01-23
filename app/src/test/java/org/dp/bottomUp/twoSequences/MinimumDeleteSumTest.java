package org.dp.bottomUp.twoSequences;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MinimumDeleteSumTest {
    /**
     * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
     */
    @Test void test1() {
        MinimumDeleteSum testDeleteSum = new MinimumDeleteSum("sea", "eat");
        int solution = testDeleteSum.solution();
        String retrieve = testDeleteSum.retrieve();

        assertAll(
                () -> assertEquals(231, solution),
                () -> assertEquals("ea", retrieve)
        );
    }

    /**
     * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
     */
    @Test void test2() {
        MinimumDeleteSum testDeleteSum = new MinimumDeleteSum("delete", "leet");
        int solution = testDeleteSum.solution();
        String retrieve = testDeleteSum.retrieve();

        assertAll(
                () -> assertEquals(403, solution),
                () -> assertEquals("let", retrieve)
        );
    }
}
