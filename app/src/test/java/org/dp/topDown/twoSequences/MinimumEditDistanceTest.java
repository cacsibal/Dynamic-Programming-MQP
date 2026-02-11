package org.dp.topDown.twoSequences;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MinimumEditDistanceTest {
    /**
     * https://leetcode.com/problems/edit-distance/description/
     */
    @Test void test1() {
        MinimumEditDistance testEditDistance = new MinimumEditDistance("horse", "ros");
        int solution = testEditDistance.solution();
        String retrieve = testEditDistance.retrieve();

        assertAll(
                () -> assertEquals(3, solution),
                () -> assertEquals("ros", retrieve)
        );
    }

    /**
     * https://leetcode.com/problems/edit-distance/description/
     */
    @Test void test2() {
        MinimumEditDistance testEditDistance = new MinimumEditDistance("intention", "execution");
        int solution = testEditDistance.solution();
        String retrieve = testEditDistance.retrieve();

        assertAll(
                () -> assertEquals(5, solution),
                () -> assertEquals("execution", retrieve)
        );
    }
}
