package org.dp.grid;

import org.dp.IBottomUp;
import org.dp.ITopDown;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Minimum Path Sum: Given an m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * (<a href="https://leetcode.com/problems/minimum-path-sum/">...</a>)
 *
 * <code>
 * minpath <- {
 * M[1,1] <- grid[1,1]
 * M[1,j] <- M[1, j-1] + grid[1,j]
 * M[i,1] <- M[i-1, 1] + grid[i,1]
 * M[i,j] <- min(M[i-1,j], M[i,j-1]) + grid[i,j]
 * } %where% {
 * i <- 1:nrow(grid)
 * j <- 1:ncol(grid)
 * }
 * </code>
 */
public class MinPathSum implements IBottomUp, ITopDown {
    int[][] grid;

    public MinPathSum(int[][] grid) {
        this.grid = grid;
    }

    public int helper_bottomup() {
        int len1 = grid.length;
        int len2 = grid[0].length;

        int[][] dp = new int[len1][len2];

        dp[0][0] = grid[0][0];

        for (int r = 1; r < len1; r++) {
            dp[r][0] = dp[r - 1][0] + grid[r][0];
        }

        for (int c = 1; c < len2; c++) {
            dp[0][c] = dp[0][c - 1] + grid[0][c];
        }

        for (int r = 1; r < len1; r++) {
            for (int c = 1; c < len2; c++) {
                dp[r][c] = Math.min(dp[r - 1][c], dp[r][c - 1]) + grid[r][c];
            }
        }

        return dp[len1 - 1][len2 - 1];
    }

    public int solution_bottomup() {
        return helper_bottomup();
    }

    public int solution() {
        return solution_bottomup();
    }

    public int solution_topdown() {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return helper_topdown(grid.length - 1, grid[0].length - 1, memo);
    }

    private int helper_topdown(int r, int c, HashMap<Integer, Integer> memo) {
        if (r == 0 && c == 0) return grid[0][0];

        int key = (r + c) * (r + c + 1) / 2 + r;
        if (memo.containsKey(key)) return memo.get(key);

        int result;
        if (r == 0) {
            result = helper_topdown(0, c - 1, memo) + grid[0][c];
        } else if (c == 0) {
            result = helper_topdown(r - 1, 0, memo) + grid[r][0];
        } else {
            result = Math.min(helper_topdown(r - 1, c, memo), helper_topdown(r, c - 1, memo)) + grid[r][c];
        }

        memo.put(key, result);
        return result;
    }
}