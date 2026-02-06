package org.dp.twoSequences;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MinimumEditDistanceTest {
    /**
     * https://leetcode.com/problems/edit-distance/description/
     */
    @Test void test1() {
        MinimumEditDistance testEditDistance = new MinimumEditDistance("horse", "ros");
        assertEquals(3, testEditDistance.solution());
    }

    /**
     * https://leetcode.com/problems/edit-distance/description/
     */
    @Test void test2() {
        MinimumEditDistance testEditDistance = new MinimumEditDistance("intention", "execution");
        assertEquals(5, testEditDistance.solution());
    }
}
