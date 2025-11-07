package org.dp.bottomUp.twoSequences;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MinimumEditDistanceTest {
    /**
     * https://leetcode.com/problems/edit-distance/description/
     */
    @Test void test1() {
        MinimumEditDistance testEditDistance = new MinimumEditDistance();
        assertEquals(3, testEditDistance.solution("horse", "ros"));
    }

    /**
     * https://leetcode.com/problems/edit-distance/description/
     */
    @Test void test2() {
        MinimumEditDistance testEditDistance = new MinimumEditDistance();
        assertEquals(5, testEditDistance.solution("intention", "execution"));
    }
}
