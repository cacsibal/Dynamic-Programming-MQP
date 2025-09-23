package org.dp.grid;

public class CountSquares {
    public int solution(int[][] grid) {
        /**
         * Iterative solution
         */
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && r > 0 && c > 0)
                    grid[r][c] += Math.min(grid[r - 1][c - 1], Math.min(grid[r - 1][c], grid[r][c - 1]));
            }
        }

        /**
         * Calculate the sum of all elements in the grid
         */
        int sum = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                sum += grid[r][c];
            }
        }

        /**
         * Return the sum of all elements in the grid
         */
        return sum;
    }
}
