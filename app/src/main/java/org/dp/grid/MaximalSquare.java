package org.dp.grid;

/**
 * Maximal Square: 
 *
 * Name: Maximal Square
 * Description:
 * 
 *    Given an m x n binary matrix filled with 0's and 1's,
 *    find the largest square containing only 1's and return its area.
 *    <a href="https://leetcode.com/problems/maximal-square/">...</a>
 * 
 * Problem Decomposition:
 * 
 *    
 * 
 * Input Type: integer[][]
 * Output Type: integer       -- representing AREA of the square
 * Solution Type: int[]       -- (r,c) that demarcate the upper left coordinate of square whose side is sqrt(result)
 * 
 * dynProg
 * 
 * maximalsquare <- {
 *   S[1,j] <- matrix_data[1,j]
 *   S[i,1] <- matrix_data[i,1]
 *   S[i,j] <- 0 ? matrix_data[i,j] == 0
 *   S[i,j] <- min(S[i-1,j], S[i,j-1], S[i-1,j-1]) + 1
 * } %where% {
 *   i <- 1:nrow(matrix_data)
 *   j <- 1:ncol(matrix_data)
 * } # returns the side length of the largest square
 */
public class MaximalSquare {
    int[][] grid;
    int[][] dp;
    int[] computed_solution = new int[] { -1, -1 };

    public MaximalSquare(int[][] grid) {
        this.grid = grid;
    }

    public int solution_bottomup() {
        dp = new int[grid.length][grid[0].length];
        int maxLength = 0;

        /**
         * Iterative solution
         */
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (r == 0 || c == 0 || grid[r][c] == 0) {
                    if (grid[r][c] == 1) {
                        dp[r][c] = 1;
                    } else {
                        dp[r][c] = 0;
                    }
                } else {
                    int best = Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1]));
                    dp[r][c] = best + 1;
                }

                if (dp[r][c] > maxLength) {
                    computed_solution[0] = r;
                    computed_solution[1] = c;
                }
                maxLength = Math.max(maxLength, dp[r][c]);
            }
        }

        /**
         * Return maximum square length
         */
        return maxLength * maxLength;
    }

    // Retrieve solution
    // =======================================
    public int[] retrieve() {
       return computed_solution;
    }
}
