package org.dp.bottomUp.grid;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UniquePathsTest {
    /**
     * https://leetcode.com/problems/unique-paths/description/
     */
    @Test void test1() {
        UniquePaths testUniquePaths = new UniquePaths(3, 2);
        assertEquals(3, testUniquePaths.solution());
    }

    /**
     * https://leetcode.com/problems/unique-paths/description/
     */
    @Test void test2() {
        UniquePaths testUniquePaths = new UniquePaths(7, 3);
        assertEquals(28, testUniquePaths.solution());
    }
}
