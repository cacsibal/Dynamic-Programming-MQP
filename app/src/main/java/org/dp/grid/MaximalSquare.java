package org.dp.grid;

public class MaximalSquare {
    public int solution(char[][] matrix) {
        /**
         * Initialization
         */
        int len1 = matrix.length;
        int len2 = matrix[0].length;

        int[][] dp = new int[len1][len2];
        int maxLength = 0;

        /**
         * Iterative solution
         */
        for(int r = 0; r < len1; r++){
            for(int c = 0; c < len2; c++){
                if(r == 0 || c == 0 || matrix[r][c] == '0') {
                    if(matrix[r][c] == '1'){
                        dp[r][c] = 1;
                    } else {
                        dp[r][c] = 0;
                    }
                } else {
                    dp[r][c] = Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1])) + 1;
                }
                maxLength = Math.max(maxLength, dp[r][c]);
            }
        }

        /**
         * Return maximum square length
         */
        return maxLength * maxLength;
    }
}
