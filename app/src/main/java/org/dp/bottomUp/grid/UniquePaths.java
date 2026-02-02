package org.dp.bottomUp.grid;

/**
 * Unique Paths: How many unique paths are there from top left to bottom right of an m x n matrix?
 * <a href="https://leetcode.com/problems/unique-paths/">...</a>
 */
public class UniquePaths {
    int m;
    int n;
    int[][] dp;

    public UniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        dp = new int[m][n];
    }

    public int solution() {
        /**
         * base cases
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
