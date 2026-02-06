package org.dp.topDown.grid;

import java.util.HashMap;

public class MinPathSum {
    int[][] matrix;

    HashMap<Integer, Integer> memo;

    public MinPathSum(int[][] matrix) {
        this.matrix = matrix;
        memo = new HashMap<>();
    }

    public int solution() {
        return helper(matrix.length - 1, matrix[0].length - 1);
    }

    public int helper(int r, int c) {
        int k = (r + c) * (r + c + 1) / 2 + r;
        if(memo.containsKey(k)) return memo.get(k);

        int result;
        if(r == 0 && c == 0) result = matrix[r][c];
        else if(r == 0) result = matrix[r][c] + helper(r, c - 1);
        else if(c == 0) result = matrix[r][c] + helper(r - 1, c);
        else result = Math.min(helper(r - 1, c), helper(r, c - 1)) + matrix[r][c];

        memo.put(k, result);
        return result;
    }
}
