package org.dp.grid;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MinPathSumTest {
    /**
     * https://leetcode.com/problems/minimum-path-sum/
     */
    @Test void test1() {
        int[][] matrix = new int[][] {
                new int[] {1, 3, 1},
                new int[] {1, 5, 1},
                new int[] {4, 2, 1}
        };
        MinPathSum testMinPathSum = new MinPathSum(matrix);

        assertEquals(7, testMinPathSum.solution());
    }

    /**
     * https://leetcode.com/problems/minimum-path-sum/
     */
    @Test void test2() {
        int[][] matrix = new int[][] {
                new int[] {1, 2, 3},
                new int[] {4, 5, 6}
        };
        MinPathSum testMinPathSum = new MinPathSum(matrix);

        assertEquals(12, testMinPathSum.solution());
    }

    /**
     * edge case of a 1x1 matrix
     */
    @Test void test3() {
        int[][] matrix = new int[][] {
                new int[] {0}
        };
        MinPathSum testMinPathSum = new MinPathSum(matrix);

        assertEquals(0, testMinPathSum.solution());
    }
}