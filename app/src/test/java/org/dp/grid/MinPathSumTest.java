package org.dp.grid;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MinPathSumTest {
    /**
     * https://leetcode.com/problems/minimum-path-sum/
     */
    @Test void test1() {
        MinPathSum testMinPathSum = new MinPathSum();
        int[][] matrix = new int[][] {
                new int[] {1, 3, 1},
                new int[] {1, 5, 1},
                new int[] {4, 2, 1}
        };

        assertEquals(7, testMinPathSum.solution(matrix));
    }

    /**
     * https://leetcode.com/problems/minimum-path-sum/
     */
    @Test void test2() {
        MinPathSum testMinPathSum = new MinPathSum();
        int[][] matrix = new int[][] {
                new int[] {1, 2, 3},
                new int[] {4, 5, 6}
        };

        assertEquals(12, testMinPathSum.solution(matrix));
    }

    /**
     * edge case of a 1x1 matrix
     */
    @Test void test3() {
        MinPathSum testMinPathSum = new MinPathSum();
        int[][] matrix = new int[][] {
                new int[] {0}
        };

        assertEquals(0, testMinPathSum.solution(matrix));
    }
}