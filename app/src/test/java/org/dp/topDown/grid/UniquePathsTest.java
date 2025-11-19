package org.dp.topDown.grid;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniquePathsTest {
    /**
     * https://leetcode.com/problems/unique-paths/description/
     */
    @Test void test1() {
        UniquePaths testUniquePaths = new UniquePaths();
        assertEquals(3, testUniquePaths.solution(3, 2));
    }

    /**
     * https://leetcode.com/problems/unique-paths/description/
     */
    @Test void test2() {
        UniquePaths testUniquePaths = new UniquePaths();
        assertEquals(28, testUniquePaths.solution(7, 3));
    }
}
