package org.dp.bottomUp.grid;

/**
 * Minimum Path Sum: Given an m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * (<a href="https://leetcode.com/problems/minimum-path-sum/">...</a>)
 *
 * <code>
 * minpath <- {
 *   M[1,1] <- grid[1,1]
 *   M[1,j] <- M[1, j-1] + grid[1,j]
 *   M[i,1] <- M[i-1, 1] + grid[i,1]
 *   M[i,j] <- min(M[i-1,j], M[i,j-1]) + grid[i,j]
 * } %where% {
 *   i <- 1:nrow(grid)
 *   j <- 1:ncol(grid)
 * }
 * </code>
 */
public class MinPathSum {
    public int solution(int[][] grid) {
        /**
         * Initialization
         */
        int len1 = grid.length;
        int len2 = grid[0].length;

        /**
         * Iterative Solution
         */
        for(int r = 0; r < len1; r++) {
            for(int c = 0; c < len2; c++) {
                if(r > 0 && c > 0) {
                    grid[r][c] += Math.min(grid[r - 1][c], grid[r][c - 1]);
                } else if(r > 0) {
                    grid[r][0] += grid[r - 1][0];
                } else if(c > 0) {
                    grid[0][c] += grid[0][c - 1];
                }
            }
        }

        /**
         * Return the bottom right element
         */
        return grid[len1 - 1][len2 - 1];
    }
}