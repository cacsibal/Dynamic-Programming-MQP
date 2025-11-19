package org.dp.bottomUp.grid;

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
                    grid[r][c] = Math.min(grid[r - 1][c], grid[r][c - 1]);
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