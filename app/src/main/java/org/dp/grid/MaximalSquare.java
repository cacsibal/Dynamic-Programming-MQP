package org.dp.grid;

/**
 * Maximal Square: Given an m x n binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 * <a href="https://leetcode.com/problems/maximal-square/">...</a>
 *
 * maximalsquare <- {
 *   S[1,j] <- matrix_data[1,j]
 *   S[i,1] <- matrix_data[i,1]
 *   S[i,j] <- 0 ? matrix_data[i,j] == 0
 *   S[i,j] <- min(S[i-1,j], S[i,j-1], S[i-1,j-1]) + 1
 * } %where% {
 *   i <- 1:nrow(matrix_data)
 *   j <- 1:ncol(matrix_data)
 * } # returns the side length of the largest square
 */
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
