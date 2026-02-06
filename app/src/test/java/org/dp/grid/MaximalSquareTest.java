package org.dp.grid;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaximalSquareTest {
    /** https://leetcode.com/problems/maximal-square/description/ */
    @Test void test1() {
        int[][] matrix = new int[][] {
                new int[] {1, 0, 1, 0, 0},
                new int[] {1, 0, 1, 1, 1},
                new int[] {1, 1, 1, 1, 1},
                new int[] {1, 0, 0, 1, 0}
        };
        MaximalSquare testSquare = new MaximalSquare(matrix);

        assertEquals(4, testSquare.solution_bottomup());
        assertArrayEquals(new int[]{2, 3}, testSquare.retrieve());
    }

    /** https://leetcode.com/problems/maximal-square/description/ */
    @Test void test2() {
        int[][] matrix = new int[][] {
                new int[] {0, 1},
                new int[] {1, 0}
        };
        MaximalSquare testSquare = new MaximalSquare(matrix);

        assertEquals(1, testSquare.solution_bottomup());
        assertArrayEquals(new int[]{0, 1}, testSquare.retrieve());
    }
}