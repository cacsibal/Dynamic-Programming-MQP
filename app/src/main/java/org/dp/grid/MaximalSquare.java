package org.dp.grid;

import org.dp.IBottomUp;
import org.dp.IRetrieveSolution;
import org.dp.ITopDown;

/**
 * Maximal Square: 
 *
 * Name: Maximal Square
 * Description:
 * 
 *    Given an m x n binary matrix filled with 0's and 1's,
 *    find the largest square containing only 1's and return its side length.
 *    <a href="https://leetcode.com/problems/maximal-square/">...</a>
 * 
 * Problem Decomposition:
 * 
 *     P(i,j) = 0 if grid[i,j] == 0 
 *     P(i,j) = if grid[i,j] == 1 : 1 + min(P(i-1,j), P(i,j-1), P(i-1,j-1)) 
 * 
 * Input Type: integer[][]
 * Output Type: integer       -- representing SIDE LENGTH of the square
 * Solution Type: int[]       -- (r,c) that demarcate the upper left coordinate of square whose side is `result`
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
public class MaximalSquare implements IBottomUp, ITopDown, IRetrieveSolution {
    int[][] grid;
    int[][] dp;
    int maxSideLength;
    int[] computed_solution = new int[] { -1, -1 };

    public MaximalSquare(int[][] grid) {
        this.grid = grid;
    }

    public int solution_topdown() {
        // Iterate over all cells to start the recursive process
        maxSideLength = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                helper(i, j);
            }
        }

        return maxSideLength;
    }

    private int helper(int i, int j) {
        // Base case: out of bounds, no square can be formed
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0) {
            return 0;
        }
        
        // If the current cell is '0', it cannot be a bottom-right corner of any square > 1x1
        if (grid[i][j] == 0) {
            return 0;
        }

        // If '1', the side length is 1 + min of sides from top, left, and top-left neighbors
        int top = helper(i - 1, j);
        int left = helper(i, j - 1);
        int diagonal = helper(i - 1, j - 1);

        int currentSide = 1 + Math.min(Math.min(top, left), diagonal);
        
        // Update the global maximum side length found so far
        if (currentSide > maxSideLength) {
            computed_solution[0] = i;
            computed_solution[1] = j;
            maxSideLength = currentSide;
        }
        
        // Memoize and return the result
        return currentSide;
    }

    public int solution_bottomup() {
        dp = new int[grid.length][grid[0].length];
        maxSideLength = 0;
        
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

                if (dp[r][c] > maxSideLength) {
                    computed_solution[0] = r;
                    computed_solution[1] = c;
                }
                maxSideLength = Math.max(maxSideLength, dp[r][c]);
            }
        }

        /**
         * Return maximum square length
         */
        return maxSideLength;
    }

    // Retrieve solution
    // =======================================
    public int[] retrieve() {
       return computed_solution;
    }
}
