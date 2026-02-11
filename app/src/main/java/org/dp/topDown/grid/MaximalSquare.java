package org.dp.topDown.grid;

import java.util.HashMap;

public class MaximalSquare {
    char[][] matrix;
    HashMap<Integer, Integer> memo;

    public MaximalSquare(char[][] matrix) {
        this.matrix = matrix;

        memo = new HashMap<>();
    }

    public int solution() {
        int maxLength = 0;
        // what
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                maxLength = Math.max(maxLength, helper(r, c));
            }
        }
        return maxLength * maxLength;
    }

    public int helper(int r, int c) {
        if (r < 0 || c < 0) return 0;
        if (matrix[r][c] == '0') return 0;

        int k = (r + c) * (r + c + 1) / 2 + r;
        if (memo.containsKey(k)) return memo.get(k);

        int result;

        if (r == 0 || c == 0) result = 1;
        else result = Math.min(helper(r - 1, c), Math.min(helper(r, c - 1), helper(r - 1, c - 1))) + 1;

        memo.put(k, result);
        return result;
    }
}
