package org.dp.bottomUp.grid;

/**
 * Unique Paths: How many unique paths are there from top left to bottom right of an m x n grid?
 * <a href="https://leetcode.com/problems/unique-paths/">...</a>
 */
public class UniquePaths {
    public int solution(int m, int n) {
        /**
         * initialization
         */
        int[][] dp = new int[m][n];

        /**
         * optimization
         */
        for(int r = 0; r < m; r++) {
            dp[r][0] = 1;
        }
        for(int c = 0; c < n; c++) {
            dp[0][c] = 1;
        }

        /**
         * maximization through iteration
         */
        for(int r = 1; r < m; r++) {
            for(int c = 1; c < n; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }

        /**
         * return the last element
         */
        return dp[m - 1][n - 1];
    }
}
