package org.dp.topDown.grid;

import java.util.HashMap;

public class CountSquares {
    int[][] matrix;
    HashMap<Integer, Integer> memo;

    public CountSquares(int[][] matrix) {
        this.matrix = matrix;
        this.memo = new HashMap<>();
    }

    public int solution() {
        // what
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                helper(r, c);
            }
        }

        return memo.values().stream().reduce(0, Integer::sum);
    }

    public int helper(int r, int c) {
        if (r < 0 || c < 0) return 0;
        if (matrix[r][c] == 0) return 0;

        int k = (r + c) * (r + c + 1) / 2 + r;
        if (memo.containsKey(k)) return memo.get(k);

        int result;
        if (r == 0 || c == 0) {
            result = 1;
        } else {
            result = Math.min(helper(r - 1, c),
                    Math.min(helper(r, c - 1),
                            helper(r - 1, c - 1))) + 1;
        }

        memo.put(k, result);
        return result;
    }
}