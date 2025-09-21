package org.dp.grid;

import org.utils.MathUtils;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        // initialization
        int len1 = matrix.length;
        int len2 = matrix[0].length;

        int[][] dp = new int[len1][len2];
        int maxLength = 0;

        // maximization
        for(int r = 0; r < len1; r++){
            for(int c = 0; c < len2; c++){
                if(r == 0 || c == 0 || matrix[r][c] == '0') {
                    if(matrix[r][c] == '1'){
                        dp[r][c] = 1;
                    } else {
                        dp[r][c] = 0;
                    }
                } else {
                    dp[r][c] = MathUtils.min(dp[r - 1][c - 1], MathUtils.min(dp[r - 1][c], dp[r][c - 1])) + 1;
                }
                maxLength = MathUtils.max(maxLength, dp[r][c]);
            }
        }

        // return
        return maxLength * maxLength;
    }
}
