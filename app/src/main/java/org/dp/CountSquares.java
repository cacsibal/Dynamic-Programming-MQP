package org.dp;

import org.utils.MatrixUtils;
import org.utils.MathUtils;

public class CountSquares {
    public int countSquares(int[][] grid) {
        // maximization
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && r > 0 && c > 0)
                    grid[r][c] += MathUtils.min(grid[r - 1][c - 1], MathUtils.min(grid[r - 1][c], grid[r - 1][c - 1]));
            }
        }

        // return
        return MatrixUtils.sum(grid);
    }
}
