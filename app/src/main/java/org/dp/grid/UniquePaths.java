package org.dp.grid;

/**
 * Unique Paths: How many unique paths are there from top left to bottom right of an m x n grid?
 * <a href="https://leetcode.com/problems/unique-paths/">...</a>
 */
public class UniquePaths {

    int m;
    int n;

    public UniquePaths(int m, int n){
        this.m = m;
        this.n = n;
    }

    public int helper_bottomup() {
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

    public int helper_topdown(int i, int j) {

        // Base case - reached bottom-right cell
        if (i == m - 1 && j == n - 1)
            return 1;

        // Out of bounds
        if (i >= m || j >= n)
            return 0;

        // Move down or right
        return helper_topdown(i + 1, j)
                + helper_topdown(i, j + 1);
    }

    public int solution_bottomup() {
        return helper_bottomup();
    }

    public int solution_topdown() {
        return helper_topdown(0,0);
    }

    public int solution(){
        return solution_topdown();
    }
}