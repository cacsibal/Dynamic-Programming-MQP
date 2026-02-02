package org.dp.bottomUp.grid;

/**
 * Minimum Path Sum: Given an m x n matrix filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * (<a href="https://leetcode.com/problems/minimum-path-sum/">...</a>)
 *
 * <code>
 * minpath <- {
 *   M[1,1] <- matrix[1,1]
 *   M[1,j] <- M[1, j-1] + matrix[1,j]
 *   M[i,1] <- M[i-1, 1] + matrix[i,1]
 *   M[i,j] <- min(M[i-1,j], M[i,j-1]) + matrix[i,j]
 * } %where% {
 *   i <- 1:nrow(matrix)
 *   j <- 1:ncol(matrix)
 * }
 * </code>
 */
public class MinPathSum {
    int[][] matrix;
    int[][] dp;

    public MinPathSum(int[][] matrix) {
        this.matrix = matrix;
        this.dp = new int[matrix.length][matrix[0].length];
    }

    public int solution() {
        /**
         * Iterative Solution with DP table
         */
        for(int r = 0; r < matrix.length; r++) {
            for(int c = 0; c < matrix[0].length; c++) {
                if(r == 0 && c == 0) {
                    dp[r][c] = matrix[r][c];
                } else if(r == 0) {
                    dp[r][c] = dp[r][c - 1] + matrix[r][c];
                } else if(c == 0) {
                    dp[r][c] = dp[r - 1][c] + matrix[r][c];
                } else {
                    dp[r][c] = Math.min(dp[r - 1][c], dp[r][c - 1]) + matrix[r][c];
                }
            }
        }

        /**
         * Return the bottom right element
         */
        return dp[matrix.length - 1][matrix[0].length - 1];
    }
}