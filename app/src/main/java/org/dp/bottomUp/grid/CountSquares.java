package org.dp.bottomUp.grid;

public class CountSquares {

    int[][] grid;

    public CountSquares(int[][] grid) {
        this.grid = grid;
    }

    public int solution() {
        return solution_bottomup();
    }

    public int solution_bottomup() {
        // dp[i][j] represents the side length of the largest square with bottom-right corner at (i, j)
        int[][] dp = new int[grid.length][grid[0].length];
        
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    if (r == 0 || c == 0) {
                        dp[r][c] = 1; // First row or first column
                    } else {
                        dp[r][c] = Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1])) + 1;
                    }
                }
            }
        }

        /**
         * Calculate the sum of all elements in the grid
         */
        int sum = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                sum += dp[r][c];
            }
        }

        /**
         * Return the sum of all elements in the grid
         */
        return sum;
    }
}
