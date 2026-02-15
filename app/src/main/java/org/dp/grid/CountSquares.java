package org.dp.grid;

import org.dp.IBottomUp;
import org.dp.ITopDown;

/**
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 */
public class CountSquares implements IBottomUp {

    int[][] matrix;

    // dp[i][j] represents the side length of the largest square with bottom-right corner at (i, j)
    int[][] dp;

    public CountSquares(int[][] matrix) {
        this.matrix = matrix;

        dp = new int[matrix.length][matrix[0].length];
    }

    public int solution() {
        return solution_bottomup();
    }

    public int solution_bottomup() {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 1) {
                    if (r == 0 || c == 0) {
                        dp[r][c] = 1; // First row or first column
                    } else {
                        dp[r][c] = Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1])) + 1;
                    }
                }
            }
        }

        /**
         * Calculate the sum of all elements in the matrix
         */
        int sum = 0;
        for(int r = 0; r < matrix.length; r++) {
            for(int c = 0; c < matrix[0].length; c++) {
                sum += dp[r][c];
            }
        }

        /**
         * Return the sum of all elements in the matrix
         */
        return sum;
    }
}
